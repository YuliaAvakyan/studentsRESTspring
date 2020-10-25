package studentsrestproj.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsrestproj.demo.model.Elective;
import studentsrestproj.demo.repository.ElectiveRepository;
import studentsrestproj.demo.service.ElectiveService;

import java.util.List;

@Service
public class ElectiveServiceImpl implements ElectiveService {

    private final ElectiveRepository electiveRepository;

    @Autowired
    public ElectiveServiceImpl(ElectiveRepository electiveRepository) {
        this.electiveRepository = electiveRepository;
    }

    @Override
    public Elective create(Elective elective) {
        return electiveRepository.save(elective);
    }

    @Override
    public List<Elective> readAll() {
        return electiveRepository.findAll();
    }

    @Override
    public Elective read(Long id) {
        return electiveRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid elective Id:" + id));
    }
}
