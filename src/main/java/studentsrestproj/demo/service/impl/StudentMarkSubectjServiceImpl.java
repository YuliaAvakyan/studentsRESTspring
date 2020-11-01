package studentsrestproj.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.model.StudentMarkSubject;
import studentsrestproj.demo.model.Subject;
import studentsrestproj.demo.repository.StudMarkSubjRepository;
import studentsrestproj.demo.service.StudentMarkSubjectService;

import java.util.List;

@Service
public class StudentMarkSubectjServiceImpl implements StudentMarkSubjectService {

    private final StudMarkSubjRepository repository;

    @Autowired
    public StudentMarkSubectjServiceImpl(StudMarkSubjRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentMarkSubject create(StudentMarkSubject s) {
        return repository.save(s);
    }

    @Override
    public List<StudentMarkSubject> readAll() {
        return repository.findAll();
    }

    @Override
    public StudentMarkSubject read(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
    }

}
