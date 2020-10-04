package studentsrestproj.demo.dao;

import studentsrestproj.demo.model.Student;

import java.util.List;

public interface StudentDAO {
    void create(Student student);
    List<Student> readAll();
    Student read(int id);
    void update(Student student, int id);
    void delete(int id);

}
