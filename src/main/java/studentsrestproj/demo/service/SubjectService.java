package studentsrestproj.demo.service;

import studentsrestproj.demo.model.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> readAll();
    Subject read(Long id);
}
