package studentsrestproj.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsrestproj.demo.model.Subject;
import studentsrestproj.demo.repository.SubjectRepository;
import studentsrestproj.demo.service.SubjectService;

import java.util.List;

@Service
public class SublectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SublectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
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
