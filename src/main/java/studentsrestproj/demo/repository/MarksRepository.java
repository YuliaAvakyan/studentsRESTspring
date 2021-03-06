package studentsrestproj.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentsrestproj.demo.model.Marks;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Long> {
}
