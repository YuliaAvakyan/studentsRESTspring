package studentsrestproj.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import studentsrestproj.demo.model.Elective;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;
    private final ElectiveService electiveService;
    private final StudentMarkSubjectService studMarkSubjService;
    private final MarksService marksService;
    private final SubjectService subjectService;

    @Autowired
    public StudentController(StudentService studentService, ElectiveService electiveService, StudentMarkSubjectService studMarkSubjService, MarksService marksService, SubjectService subjectService) {
        this.studentService = studentService;
        this.electiveService = electiveService;
        this.studMarkSubjService = studMarkSubjService;
        this.marksService = marksService;
        this.subjectService = subjectService;
    }

    //CREATE
    @GetMapping("/signup")
    public String showAddForm(Student student, Model model) {
        List<Elective> electiveList = electiveService.readAll();
        model.addAttribute("student", student);
        model.addAttribute("electives", electiveList);
        model.addAttribute("subjects", subjectService.readAll());
        model.addAttribute("marks", marksService.readAll());
        model.addAttribute("mark_subj", studMarkSubjService.readAll());
        return "add-student";
    }

    @PostMapping("/addstudent")
    public String addStudent(@Valid Student student, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("electives", electiveService.readAll());
            model.addAttribute("subjects", subjectService.readAll());
            model.addAttribute("marks", marksService.readAll());
            model.addAttribute("mark_subj", studMarkSubjService.readAll());
            return "add-student";
        }
        studentService.create(student);
        model.addAttribute("students", studentService.readAll());
        return "redirect:/students";
    }


    //UPDATE
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Student student = studentService.read(id);
        List<Elective> electiveList = electiveService.readAll();
        model.addAttribute("student", student);
        model.addAttribute("electives", electiveList);
        return "update-student";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @Valid Student student,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
//            student.setId(id);
            List<Elective> electiveList = electiveService.readAll();
            model.addAttribute("electives", electiveList);
            return "update-student";
        }

        studentService.update(student, id);
        model.addAttribute("student", studentService.read(id));
        return "redirect:/students";
    }

    //DELETE
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.read(id);
        studentService.delete(student.getId());

        model.addAttribute("students", studentService.readAll());
        return "redirect:/students";
    }

    //READ
//    @GetMapping("/students")
//    public String readAllStudents(Model model) {
//        List<Student> list = studentService.readAll();
//        model.addAttribute("students", list);
//
//        return "studentsPage";
//    }

    @GetMapping("/students")
    public String readAllStudentsPaged(
            Model model,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 5) Pageable pageable) {
        Page<Student> studentPage = studentService.findPaginated(pageable);
        model.addAttribute("page", studentPage);
        return "studentsPage";
    }

    @GetMapping("/student/{id}")
    public String read(@PathVariable(name = "id") Long id, Model model) {
        final Student student = studentService.read(id);
        List<Elective> electiveList = student.getElectives();
        model.addAttribute("student", student);
        model.addAttribute("electives", electiveList);


        return "oneStudentPage";
    }

}
