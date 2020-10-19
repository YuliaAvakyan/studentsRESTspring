package studentsrestproj.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.repository.StudentRepository;

import java.util.*;

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
    public Student read(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
    }

    @Override
    public Student update(Student newStudent, Long id) {
//        if (studentRepository.existsById(id)) {
//            student.setId(id);
//            studentRepository.save(student);
//        }

        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setPhone(newStudent.getPhone());
                    student.setEmail(newStudent.getEmail());
                    student.setMarks(newStudent.getMarks());
//                    student.setElectives(newStudent.getElectives());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }

    @Override
    public void delete(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
    }

    @Override
    public Double getAvgMark(Long id){
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

    @Override
    public List<Object[]> getMarksCount(){
        return (studentRepository.getCountMarks());
    }

    @Override
    public List<Object[]> getSumMark() {
        return studentRepository.getSumMark();
    }


    @Override
    public List<Student> getElectiveStudents(Long id) {
        List<Student> students = studentRepository.findAll();
        List<Student> studentList = new ArrayList<>();
        return students;
    }
}
