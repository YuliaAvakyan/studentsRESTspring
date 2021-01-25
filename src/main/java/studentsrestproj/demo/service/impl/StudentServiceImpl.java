package studentsrestproj.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import studentsrestproj.demo.events.StudentCreationEvent;
import studentsrestproj.demo.events.StudentDeleteEvent;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.model.StudentMarkSubject;
import studentsrestproj.demo.repository.StudMarkSubjRepository;
import studentsrestproj.demo.repository.StudentRepository;
import studentsrestproj.demo.service.StudentService;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudMarkSubjRepository studMarkSubjRepository;
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudMarkSubjRepository studMarkSubjRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.studentRepository = studentRepository;
        this.studMarkSubjRepository = studMarkSubjRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @Override
    public Student create(Student student) {
        for (StudentMarkSubject ms : student.getStudentMarkSubjects()) {
            StudentMarkSubject newMs = studMarkSubjRepository.getStudentMarkSubjectByMarkAndSubject(ms.getMark(), ms.getSubject());
            if (newMs != null) {
                ms.setId(newMs.getId());
            }
        }
        Student newStudent = studentRepository.save(student);

        StudentCreationEvent studentCreatEvent = new StudentCreationEvent(newStudent);
        applicationEventPublisher.publishEvent(studentCreatEvent);
        return newStudent;
    }

    @Override
    public List<Student> readAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student read(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
    }

    @Override
    public Student update(Student newStudent, Long id) {

        for (StudentMarkSubject ms : newStudent.getStudentMarkSubjects()) {
            StudentMarkSubject newMs = studMarkSubjRepository.getStudentMarkSubjectByMarkAndSubject(ms.getMark(), ms.getSubject());
            if (newMs != null) {
                ms.setId(newMs.getId());
            }
        }

        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setPhone(newStudent.getPhone());
                    student.setEmail(newStudent.getEmail());
                    student.setElectives(newStudent.getElectives());
                    student.setStudentMarkSubjects(newStudent.getStudentMarkSubjects());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }

    @Override
    public void delete(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            StudentDeleteEvent studentDeleteEvent = new StudentDeleteEvent(id);
            applicationEventPublisher.publishEvent(studentDeleteEvent);
        }

    }

    @Override
    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Page<Student> findPaginated(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> findFilterByName(String name, Pageable pageable) {
        return studentRepository.findByName(name, pageable);
    }

}
