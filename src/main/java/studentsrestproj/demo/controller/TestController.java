package studentsrestproj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentsrestproj.demo.model.*;
import studentsrestproj.demo.service.StudentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {


    private StudentService studentService;


    @Autowired
    public TestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("add")
    public void addStude(){
        Student student = new Student();
        student.setName("stas");
        student.setPhone("9429342934");
        student.setEmail("klsad@mail.ru");

        Elective elective = new Elective();
        elective.setName("Hockey1");


        Elective elective1 = new Elective();
        elective1.setName("Football1");

        student.setElectives(Arrays.asList(
                elective, elective1
        ));


        Marks m = new Marks();
        m.setMark(5);
        Subject s = new Subject();
        s.setName("History");

        StudentMarkSubject sm = new StudentMarkSubject();
        sm.setMark(m);
        sm.setSubject(s);

        student.setStudentMarkSubjects(Arrays.asList(sm));

        studentService.create(student);
    }
}
