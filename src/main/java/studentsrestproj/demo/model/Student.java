package studentsrestproj.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "student", orphanRemoval = true, cascade = CascadeType.ALL)
//    @OneToMany
    private List<Marks> marks = new ArrayList<>();

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
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

    public List<Marks> getMarks() {
        return new ArrayList<>(marks);
    }

    public void setMarks(Collection<Marks> marks){
        this.marks.addAll(marks);
    }

    public List<Elective> getElectives() {
        return new ArrayList<>(electives);
    }

    public void setElectives(List<Elective> electives) {
        this.electives = electives;
    }
}