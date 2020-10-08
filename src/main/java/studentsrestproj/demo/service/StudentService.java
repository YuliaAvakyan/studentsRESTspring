package studentsrestproj.demo.service;

import studentsrestproj.demo.model.Student;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface StudentService {
    Student create(Student student);
    List<Student> readAll();
    Student read(Long id);
    Student update(Student student, Long id);
    void delete(Long id);
    Double getAvgMark(Long id);
    List<Double> getAvgMarkForAll();
    List<Student> getStudentsWithMark(double m1, double m2);
    List<Object[]> getMarksCount();
    Object getSumMark();
}
