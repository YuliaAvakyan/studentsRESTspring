package studentsrestproj.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsrestproj.demo.model.Subject;
import studentsrestproj.demo.model.Subject;
import studentsrestproj.demo.repository.MarksRepository;
import studentsrestproj.demo.repository.SubjectRepository;
import studentsrestproj.demo.service.MarksService;
import studentsrestproj.demo.service.SubjectService;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject create(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> readAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject read(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject Id:" + id));
    }
}
