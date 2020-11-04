package studentsrestproj.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.service.impl.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = StudentController.class)
@SpringBootTest
public class StudentControllerTest1 {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentServiceImpl studentService;
    @MockBean
    private ElectiveServiceImpl electiveService;
    @MockBean
    private MarksServiceImpl marksService;
    @MockBean
    private SubjectServiceImpl subjectService;
    @MockBean
    private StudentMarkSubectjServiceImpl studentMarkSubectjService;

    private List<Student> studentList;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @BeforeEach
    void setUp() {
        this.studentList = new ArrayList<>();
        Student student = new Student();
        student.setName("Alena");
        student.setPhone("123456789");
        student.setEmail("al@al.ru");

        Student student1 = new Student();
        student1.setName("Alena1");
        student1.setPhone("123456789");
        student1.setEmail("al1@al.ru");

        Student student2 = new Student();
        student2.setName("Alena2");
        student2.setPhone("123456789");
        student2.setEmail("al2@al.ru");
        this.studentList.add(student);
        this.studentList.add(student1);
        this.studentList.add(student2);

//        objectMapper.registerModule(new ProblemModule());
//        objectMapper.registerModule(new ConstraintViolationProblemModule());
    }

    @Test
    public void addStudent() {
    }

    @Test
    public void updateStudent() {
    }

    @Test
    public void deleteStudent() {
    }

    @Test
    public void readAllStudentsPaged() throws Exception {
        this.mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(view().name("studentsPage"));
    }

    @Test
    public void read() {
    }
}