package studentsrestproj.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //CREATE
    @GetMapping("/signup")
    public String showAddForm(Student student, Model model) {
        model.addAttribute("student", student);
        return "add-student";
    }

    @PostMapping("/addstudent")
    public String addStudent(@Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
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
        model.addAttribute("student", student);
        return "update-student";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @Valid Student student,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
//            student.setId(id);
            return "update-student";
        }

        studentService.update(student, id);
        model.addAttribute("students", studentService.readAll());
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
    @GetMapping("/students")
    public String readAllStudents(Model model) {
        List<Student> list = studentService.readAll();
        model.addAttribute("students", list);

        return "studentsPage";
    }

    @GetMapping("/student/{id}")
    public String read(@PathVariable(name = "id") Long id, Model model) {
        final Student student = studentService.read(id);
        model.addAttribute("student", student);

        return "oneStudentPage";
    }

}
