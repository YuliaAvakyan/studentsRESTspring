package studentsrestproj.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.repository.MarksRepository;
import studentsrestproj.demo.repository.StudentRepository;
import studentsrestproj.demo.service.MarksService;

import java.util.List;

@Service
public class MarksServiceImpl implements MarksService {

    private final MarksRepository marksRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public MarksServiceImpl(MarksRepository marksRepository, StudentRepository studentRepository) {
        this.marksRepository = marksRepository;
        this.studentRepository = studentRepository;
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
                .orElseThrow(() -> new IllegalArgumentException("Invalid marks Id:" + id));
    }

    @Override
    public List<Marks> findByStudentId(Long studentId) {
        return marksRepository.findByStudentId(studentId);
    }

    @Override
    public Marks update(Marks newMark, Long id) {
        return marksRepository.findById(id)
                .map(mark -> {
                    mark.setMark(newMark.getMark());
                    mark.setSubject(newMark.getSubject());
                    return marksRepository.save(mark);
                })
                .orElseGet(() -> {
                    newMark.setId(id);
                    return marksRepository.save(newMark);
                });
    }
}
