package studentsrestproj.demo.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    private String phone;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<StudentMarkSubject> studentMarkSubjects;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "elective_students",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "elective_id"))
    List<Elective> electives = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Elective> getElectives() {
        return new ArrayList<>(electives);
    }

    public void setElectives(List<Elective> electives) {
        this.electives = electives;
    }

    public List<StudentMarkSubject> getStudentMarkSubjects() {
        return studentMarkSubjects;
    }

    public void setStudentMarkSubjects(List<StudentMarkSubject> studentMarkSubjects) {
        this.studentMarkSubjects = studentMarkSubjects;
    }

    //    public void addMark(Marks mark) {
//        marks.add(mark);
//        mark.setStudent(this);
//    }
//
//    public void removeMark(Marks mark) {
//        marks.remove(mark);
////        mark.setStudent(null);
//    }
}