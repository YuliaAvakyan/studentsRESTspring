package studentsrestproj.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.service.StudentService;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Student student) {
        return "add-student";
    }

    @PostMapping("/addstudent")
    public String addUser(Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }

        studentService.create(student);
        model.addAttribute("students", studentService.readAll());
        return "redirect:/index";
    }



//    @PostMapping(value = "/students")
//    public ResponseEntity<?> create(@RequestBody Student student) {
//        studentService.create(student);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

//    @GetMapping(value = "/students/list")
//    public ResponseEntity<List<Student>> read() {
//        final List<Student> students = studentService.readAll();
//
//        return students != null &&  !students.isEmpty()
//                ? new ResponseEntity<>(students, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping(value = "/students/{id}")
//    public ResponseEntity<Student> read(@PathVariable(name = "id") int id, Model model) {
//        final Student student = studentService.read(id);
//        model.addAttribute("id", id);
//
//        return student != null
//                ? new ResponseEntity<>(student, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }





//    @PutMapping(value = "/students/{id}")
//    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Student student) {
//        studentService.update(student, id);
//
//        return updated
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
//
//    @DeleteMapping(value = "/students/{id}")
//    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
//        final boolean deleted = studentService.delete(id);
//
//        return deleted
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
}
