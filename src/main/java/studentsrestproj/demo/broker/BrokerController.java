package studentsrestproj.demo.broker;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.service.StudentService;

import java.util.List;

@Controller
public class BrokerController {
    private final StudentService studentService;

    public BrokerController(StudentService studentService) {
        this.studentService = studentService;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ResponseEntity<List<Student>> read() {
        final List<Student> students = studentService.readAll();
        return ResponseEntity.ok(students);
    }

    @SubscribeMapping("/students/get")
    public List<Student> readAll() {
        return studentService.readAll();
    }

}
