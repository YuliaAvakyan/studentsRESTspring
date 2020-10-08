package studentsrestproj.demo.DTO;

import java.util.ArrayList;
import java.util.List;

public class StudentDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<MarkDTO> marks = new ArrayList<>();

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

    public List<MarkDTO> getMarks() {
        return new ArrayList<>(marks);
    }

    public void setMarks(List<MarkDTO> marks) {
        this.marks = marks;
    }
}
