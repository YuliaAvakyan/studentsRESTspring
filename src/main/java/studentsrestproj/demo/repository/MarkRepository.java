package studentsrestproj.demo.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.model.Student;

import java.util.List;

public interface MarkRepository extends JpaRepository<Marks, Integer> {

    List<Marks> findByStudent(Student student, Sort sort);
}
