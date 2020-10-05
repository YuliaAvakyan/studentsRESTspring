package studentsrestproj.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

//    private final StudentDAO studentDAO;

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    @Autowired
//    public StudentServiceImpl(StudentDAO studentDAO) {
//        this.studentDAO = studentDAO;
//    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> readAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student read(int id) {
        return studentRepository.getOne(id);
    }

    @Override
    public void update(Student student, int id) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            studentRepository.save(student);
        }
    }

    @Override
    public void delete(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
    }
}
