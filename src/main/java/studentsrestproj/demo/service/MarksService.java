package studentsrestproj.demo.service;

import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.model.Student;

import java.util.List;

public interface MarksService {
    Marks create(Marks marks);
    List<Marks> readAll();
    Marks read(Long id);
    List<Marks> findByStudentId(Long studentId);
    Marks update(Marks mark, Long id);

    List<Marks> saveAll(List<Marks> marks);

}
