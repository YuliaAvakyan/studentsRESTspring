package studentsrestproj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentRestController {

    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
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
    public void deleteEmployee(@PathVariable Long id) {
        studentService.delete(id);
    }


    @GetMapping("/avg/{id}")
    public ResponseEntity<Double> averageMark(@PathVariable("id") Long id) {

        return ResponseEntity.ok(studentService.getAvgMark(id));
    }

    @GetMapping("/allAvg")
    public ResponseEntity<List<Double>> averageMarkAll() {
        return ResponseEntity.ok(studentService.getAvgMarkForAll());
    }


    @RequestMapping("/avg")
    public ResponseEntity<List<Student>> studentWithMark(@RequestParam("min") double min,
                                                         @RequestParam("max") double max) {
        return ResponseEntity.ok(studentService.getStudentsWithMark(min, max));
    }

    @GetMapping("/countMarks")
    public ResponseEntity<List<Object[]>> getMarksCount() {
        return ResponseEntity.ok(studentService.getMarksCount());
    }

    @GetMapping("/sumMarks")
    public ResponseEntity<List<Object[]>> getSum() {
        return ResponseEntity.ok(studentService.getSumMark());
    }

}
