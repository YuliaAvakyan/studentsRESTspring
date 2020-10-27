package studentsrestproj.demo.service;

import studentsrestproj.demo.model.Subject;

import java.util.List;

public interface SubjectService {

    Subject create(Subject subject);
    List<Subject> readAll();
    Subject read(Long id);
}
