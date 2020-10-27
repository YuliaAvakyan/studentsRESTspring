package studentsrestproj.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "subject", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<StudentMarkSubject> studentMarkSubjects;

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

    public List<StudentMarkSubject> getStudentMarkSubjects() {
        return studentMarkSubjects;
    }

    public void setStudentMarkSubjects(List<StudentMarkSubject> studentMarkSubjects) {
        this.studentMarkSubjects = studentMarkSubjects;
    }
}
