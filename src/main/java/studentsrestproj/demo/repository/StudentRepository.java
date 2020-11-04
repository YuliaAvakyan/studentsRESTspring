package studentsrestproj.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import studentsrestproj.demo.model.Student;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Query(value = "SELECT COUNT (M.mark), M.subject FROM Marks M GROUP BY M.subject")
//    List<Object[]> getCountMarks();

//    @Query(value = "SELECT st.id from Student st join st.marks mk group by st.id having avg (mk) > 4")
//    List<Object[]> getSumMark();

    Page<Student> findByName(String name, Pageable pageable);
    Student findByName(String name);


//    @Query(value = "SELECT sum(m.mark) from Student s join s.marks m where s.id in " +
//            "(SELECT st.id from Student st join st.marks mk having avg (mk) > 4)")

//    @Query(value = "SELECT st.id from Student st join st.marks mk group by st.id having avg (mk) > 4")


}
