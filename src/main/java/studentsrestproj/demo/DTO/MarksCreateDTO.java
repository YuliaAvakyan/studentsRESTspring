package studentsrestproj.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.model.Subject;

import javax.persistence.*;
import java.util.List;

public class MarksCreateDTO {

    private List<Marks> marks;

    public MarksCreateDTO(List<Marks> marks) {
        this.marks = marks;
    }

    public MarksCreateDTO() {
    }

    public void addMark(Marks mark) {
        this.marks.add(mark);
    }

    public List<Marks> getMarks() {
        return marks;
    }

    public void setMarks(List<Marks> marks) {
        this.marks = marks;
    }
}
