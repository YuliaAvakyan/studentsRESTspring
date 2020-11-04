package studentsrestproj.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.service.StudentMarkSubjectService;
import studentsrestproj.demo.service.impl.*;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(controllers = StudentController.class)
@ActiveProfiles("test")
class StudentControllerTest {

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

    @Autowired
    private ObjectMapper objectMapper;


    private List<Student> studentList;

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
    void addStudent() throws Exception {
        given(studentService.create(any(Student.class))).willAnswer((invocation) -> invocation.getArgument(0));

        Student student = new Student();
        student.setName("Alena");
        student.setPhone("123456789");
        student.setEmail("al@al.ru");

//        String jsonReq = objectMapper.writeValueAsString(student);

//        MvcResult mvcResult = this.mockMvc.perform(post("/addstudent")
//                .content(objectMapper.writeValueAsString(student))
//                .content(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk()).andReturn();
//
//        String resultContent = mvcResult.getResponse().getContentAsString();

                this.mockMvc.perform(post("/addstudent")
                .content(objectMapper.writeValueAsString(student))
                .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.email").value("al@al.ru"))
//                .andExpect(jsonPath("$.phone", is(student.getPhone())))
//                .andExpect(jsonPath("$.name", is(student.getName())));
    }

    @Test
    void updateStudent() {
    }

    @Test
    void deleteStudent() {
    }

    @Test

    void readAllStudentsPaged() throws Exception {

        given(studentService.readAll()).willReturn(studentList);

        this.mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(view().name("studentsPage"))
                .andExpect(jsonPath("$.size()", is(studentList.size())));
    }

    @Test
    void read() throws Exception {
        final Long stId = 1L;
        final Student student = new Student();
        student.setName("Alena");
        student.setPhone("123456789");
        student.setEmail("al@al.ru");

        given(studentService.read(stId)).willReturn(student);

        this.mockMvc.perform(get("/student/{id}", stId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(student.getEmail())))
                .andExpect(jsonPath("$.name", is(student.getName())));
    }
}