package studentsrestproj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentsrestproj.demo.model.Elective;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.service.StudentService;

import java.util.Arrays;

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
        elective.setName("Hockey");


        Elective elective1 = new Elective();
        elective1.setName("Football");

        student.setElectives(Arrays.asList(
                elective, elective1
        ));

        studentService.create(student);
    }
}
