package studentsrestproj.demo.service;

import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.model.StudentMarkSubject;
import studentsrestproj.demo.model.Subject;

import java.util.List;

public interface StudentMarkSubjectService {

    StudentMarkSubject create(StudentMarkSubject elective);
    List<StudentMarkSubject> readAll();
    StudentMarkSubject read(Long id);
}
