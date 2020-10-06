package studentsrestproj.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.repository.MarkRepository;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService {

    private final MarkRepository markRepository;

    @Autowired
    public MarkServiceImpl(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @Override
    public List<Marks> readAll() {
        return markRepository.findAll();
    }

    @Override
    public Marks read(int id) {
        return markRepository.getOne(id);
    }
}
