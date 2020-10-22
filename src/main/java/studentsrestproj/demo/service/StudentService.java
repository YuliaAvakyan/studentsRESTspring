package studentsrestproj.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    List<Object[]> getSumMark();
    Page<Student> findPaginated(Pageable pageable);
    Page<Student> findFilterByName(String name, Pageable pageable);
    Page<Student> findFilterByElective(String elective, Pageable pageable);

}
