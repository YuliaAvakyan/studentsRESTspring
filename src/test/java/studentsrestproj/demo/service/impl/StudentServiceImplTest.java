package studentsrestproj.demo.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import studentsrestproj.demo.model.*;
import studentsrestproj.demo.repository.StudMarkSubjRepository;
import studentsrestproj.demo.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudMarkSubjRepository studMarkSubjRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    void create() {
        Student student = new Student();
        student.setName("Alena");
        student.setPhone("0123456789");
        student.setEmail("alena@alena.ru");
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

        given(studentRepository.save(student)).willAnswer(invocation -> invocation.getArgument(0));

        Student savedStudent = studentService.create(student);
        assertThat(savedStudent).isNotNull();
        verify(studentRepository).save(any(Student.class));
    }

    @Test
    void readAll() {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setName("Alena");
        student.setPhone("123456789");
        student.setEmail("al@al.ru");
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

        Student student1 = new Student();
        student1.setName("Alena1");
        student1.setPhone("123456789");
        student1.setEmail("al1@al.ru");

        Student student2 = new Student();
        student2.setName("Alena2");
        student2.setPhone("123456789");
        student2.setEmail("al2@al.ru");
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);



        given(studentRepository.findAll()).willReturn(studentList);
        List<Student> expected = studentService.readAll();

        assertEquals(expected, studentList);
    }

    @Test
    void read() {
        Long id = 1L;
        Student student = new Student();
        student.setId(id);
        student.setName("Alena");
        student.setPhone("123456789");
        student.setEmail("al@al.ru");
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

        given(studentRepository.findById(id)).willReturn(Optional.of(student));
        Student expected = studentService.read(id);
        assertEquals(expected, student);
        assertThat(expected).isNotNull();

    }

    @Test
    void update() {
        Long id = 1L;
        Student student = new Student();
        student.setId(id);
        student.setName("Alena");
        student.setPhone("123456789");
        student.setEmail("al@al.ru");
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

        given(studentRepository.save(student)).willReturn(student);

        final Student expected = studentService.update(student, student.getId());

        assertThat(expected).isNotNull();

        verify(studentRepository).save(any(Student.class));
    }

    @Test
    void delete() {

        final Long userId=1L;

        studentRepository.deleteById(userId);
        studentService.delete(userId);

        verify(studentRepository, times(1)).deleteById(userId);
    }

    @Test
    void findByName() {

        Long id = 1L;
        String name = "Alena";
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setPhone("123456789");
        student.setEmail("al@al.ru");

        given(studentRepository.findByName(name)).willReturn(student);
        Student expected = studentService.findByName(name);
        assertEquals(expected, student);
        assertThat(expected).isNotNull();
    }
}