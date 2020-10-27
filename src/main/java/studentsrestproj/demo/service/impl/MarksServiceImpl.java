package studentsrestproj.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.repository.MarksRepository;
import studentsrestproj.demo.service.MarksService;

import java.util.List;

@Service
public class MarksServiceImpl implements MarksService {

    private final MarksRepository marksRepository;

    @Autowired
    public MarksServiceImpl(MarksRepository marksRepository) {
        this.marksRepository = marksRepository;
    }

    @Override
    public Marks create(Marks marks) {
        return marksRepository.save(marks);
    }

    @Override
    public List<Marks> readAll() {
        return marksRepository.findAll();
    }

    @Override
    public Marks read(Long id) {
        return marksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid mark Id:" + id));
    }
}
