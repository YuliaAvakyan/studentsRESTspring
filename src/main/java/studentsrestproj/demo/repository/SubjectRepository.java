package studentsrestproj.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentsrestproj.demo.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
