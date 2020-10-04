package studentsrestproj.demo.dao;

import org.springframework.stereotype.Repository;
import studentsrestproj.demo.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Student> students = new HashMap<>();


    @Override
    public void create(Student student) {
        student.setId(AUTO_ID.getAndIncrement());
        students.put(student.getId(), student);

    }

    @Override
    public List<Student> readAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Student read(int id) {
        return students.get(id);
    }

    @Override
    public void update(Student student, int id) {
        if (students.containsKey(id)) {
            student.setId(id);
            students.put(id, student);
        }
    }

    @Override
    public void delete(int id) {
        students.remove(id);
    }
}
