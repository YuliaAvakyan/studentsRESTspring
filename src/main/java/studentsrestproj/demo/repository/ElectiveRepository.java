package studentsrestproj.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentsrestproj.demo.model.Elective;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.model.Student;

import java.util.List;

@Repository
public interface ElectiveRepository  extends JpaRepository<Elective, Long> {
}
