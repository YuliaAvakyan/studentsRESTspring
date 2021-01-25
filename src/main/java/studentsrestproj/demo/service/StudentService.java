package studentsrestproj.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import studentsrestproj.demo.model.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);
    List<Student> readAll();
    Student read(Long id);
    Student update(Student student, Long id);
    void delete(Long id);
    Student findByName(String name);
    Page<Student> findPaginated(Pageable pageable);
    Page<Student> findFilterByName(String name, Pageable pageable);

}
