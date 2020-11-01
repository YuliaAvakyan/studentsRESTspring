package studentsrestproj.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.model.StudentMarkSubject;
import studentsrestproj.demo.model.Subject;

import java.util.List;

@Repository
public interface StudMarkSubjRepository extends JpaRepository<StudentMarkSubject, Long> {

    public StudentMarkSubject getStudentMarkSubjectByMarkAndSubject(Marks mark, Subject subject);
}
