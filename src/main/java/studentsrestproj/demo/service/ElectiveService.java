package studentsrestproj.demo.service;

import studentsrestproj.demo.model.Elective;
import studentsrestproj.demo.model.Student;

import java.util.List;

public interface ElectiveService {

    Elective create(Elective elective);
    List<Elective> readAll();
    Elective read(Long id);

}
