package studentsrestproj.demo.events;

import org.springframework.context.ApplicationEvent;

public class StudentDeleteEvent  extends ApplicationEvent {
    private long student_id;

    public StudentDeleteEvent(long student_id) {
        super(student_id);
        this.student_id = student_id;
    }
    public long getStudentId() {
        return student_id;
    }
}
