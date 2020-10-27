package studentsrestproj.demo.service;

import studentsrestproj.demo.model.Marks;

import java.util.List;

public interface MarksService {

    Marks create(Marks marks);
    List<Marks> readAll();
    Marks read(Long id);
}
