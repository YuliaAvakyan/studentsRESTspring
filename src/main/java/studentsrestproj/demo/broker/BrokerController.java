package studentsrestproj.demo.broker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import studentsrestproj.demo.events.StudentCreationEvent;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.service.MarksService;
import studentsrestproj.demo.service.StudentService;

import java.util.List;

@Controller
public class BrokerController {
    private final Log log = LogFactory.getLog(getClass());
    private final SimpMessagingTemplate websocket;
    private final StudentService studentService;
    private final MarksService marksService;

    @Autowired
    public BrokerController(SimpMessagingTemplate websocket, StudentService studentService, MarksService marksService) {
        this.websocket = websocket;
        this.studentService = studentService;
        this.marksService = marksService;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public List<Marks> read() throws InterruptedException {
        final List<Marks> marks = marksService.readAll();
        Thread.sleep(1000); // simulated delay
        return marks;
    }

    @MessageMapping("/addStudent")
    @SendTo("/topic/greetings")
    public Student addStudent(@RequestBody Student student) {
        return studentService.create(student);
    }


    @MessageMapping("/deleteStudent")
    @SendTo("/topic/greetings")
    public long deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return id;
    }

//    @SubscribeMapping("/students/get")
//    public List<Student> readAll() {
//        return studentService.readAll();
//    }

}
