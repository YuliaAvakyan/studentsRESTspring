package studentsrestproj.demo.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mark_subject", uniqueConstraints = { @UniqueConstraint( columnNames = { "mark_id", "subject_id" } ) } )
public class StudentMarkSubject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "mark_id")
    private Marks mark;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "subject_id")
    private Subject subject;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Marks getMark() {
        return mark;
    }

    public void setMark(Marks mark) {
        this.mark = mark;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
