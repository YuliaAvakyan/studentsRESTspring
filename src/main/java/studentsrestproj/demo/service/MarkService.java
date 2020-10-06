package studentsrestproj.demo.service;

import studentsrestproj.demo.model.Marks;

import java.util.List;

public interface MarkService {

    List<Marks> readAll();
    Marks read(int id);
}
