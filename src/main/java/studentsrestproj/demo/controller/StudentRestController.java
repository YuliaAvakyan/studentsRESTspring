package studentsrestproj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentsrestproj.demo.model.Elective;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.model.Subject;
import studentsrestproj.demo.service.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentRestController {

    private final StudentService studentService;
    private final ElectiveService electiveService;
    private final MarksService marksService;
    private final SubjectService subjectService;

    @Autowired
    public StudentRestController(StudentService studentService, ElectiveService electiveService, StudentMarkSubjectService studentMarkSubjectService, MarksService marksService, SubjectService subjectService) {
        this.studentService = studentService;
        this.electiveService = electiveService;
        this.marksService = marksService;
        this.subjectService = subjectService;
    }


    @PostMapping("/create")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.create(student));
    }

    @GetMapping
    public ResponseEntity<List<Student>> read() {
        final List<Student> students = studentService.readAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> read(@PathVariable(name = "id") Long id) {
        final Student student = studentService.read(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        return ResponseEntity.ok(studentService.update(newStudent, id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
    }

//Get all electives
    @GetMapping("/electives")
    public ResponseEntity<List<Elective>> readElectives() {
        final List<Elective> electiveList = electiveService.readAll();
        return ResponseEntity.ok(electiveList);
    }

    //Get all marks
    @GetMapping("/marks")
    public ResponseEntity<List<Marks>> readMarks() {
        final List<Marks> marksList = marksService.readAll();
        return ResponseEntity.ok(marksList);
    }

    //Get all subjects
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> readSubjects() {
        final List<Subject> subjectList = subjectService.readAll();
        return ResponseEntity.ok(subjectList);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Student>> read(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        final Page<Student> studentPage = studentService.findPaginated(pageable);
        return ResponseEntity.ok(studentPage);
    }

}
