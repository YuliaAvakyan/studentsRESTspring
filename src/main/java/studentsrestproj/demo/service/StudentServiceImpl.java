package studentsrestproj.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


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
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
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

    @Override
    public Double getAvgMark(int id){
        Student student = read(id);
        List<Integer> allMark = new ArrayList<>();
        for (Marks mark: student.getMarks()) {
            allMark.add(mark.getMark());
        }
        return allMark.stream().mapToInt(val -> val).average().orElse(0.0);
    }

    @Override
    public List<Double> getAvgMarkForAll(){
        List<Student> students = studentRepository.findAll();
        List<Double> marks = new ArrayList<>();
        for (Student st: students){
            marks.add(getAvgMark(st.getId()));
        }
        return marks;
    }
    @Override
    public List<Student> getStudentsWithMark(double m1, double m2){
        List<Student> students = studentRepository.findAll();
        List<Student> studentList = new ArrayList<>();
        for (Student st: students){
            double avg = getAvgMark(st.getId());
            if(m1 <= avg && avg <= m2){
                studentList.add(st);
            }
        }
        return studentList;
    }


}
