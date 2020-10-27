package studentsrestproj.demo.service;

import studentsrestproj.demo.model.StudentMarkSubject;

import java.util.List;

public interface StudentMarkSubjectService {

    StudentMarkSubject create(StudentMarkSubject elective);
    List<StudentMarkSubject> readAll();
    StudentMarkSubject read(Long id);
}
