package studentsrestproj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.service.StudentService;

import java.util.List;

@RestController
public class StudentRestController {

    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping(value = "/")
    public ResponseEntity<List<Student>> read() {
        final List<Student> students = studentService.readAll();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/st/{id}")
    public ResponseEntity<Student> read(@PathVariable(name = "id") int id) {
        final Student student = studentService.read(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(value = "/avg/{id}")
    public ResponseEntity<Double> averageMark(@PathVariable(name = "id") int id) {

        return new ResponseEntity<>(studentService.getAvgMark(id), HttpStatus.OK);
    }

    @GetMapping(value = "/avg")
    public ResponseEntity<List<Double>> averageMarkAll() {
        return new ResponseEntity<>(studentService.getAvgMarkForAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/avg/{m1}/{m2}")
    public ResponseEntity<List<Student>> studentWithMark(@PathVariable(name = "m1") double m1,
                                                        @PathVariable(name = "m2") double m2) {

        return new ResponseEntity<>(studentService.getStudentsWithMark(m1, m2), HttpStatus.OK);
    }
}
