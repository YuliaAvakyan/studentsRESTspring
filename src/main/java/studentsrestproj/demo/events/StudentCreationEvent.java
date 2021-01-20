package studentsrestproj.demo.events;

import org.springframework.context.ApplicationEvent;
import studentsrestproj.demo.model.Student;

public class StudentCreationEvent extends ApplicationEvent {
    private Student student;

    public StudentCreationEvent(Student student) {
        super(student);
        this.student = student;
    }
    public Student getStudent() {
        return student;
    }
}
