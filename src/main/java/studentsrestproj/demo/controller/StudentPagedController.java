package studentsrestproj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.service.StudentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("api/v1/pagedStudents")
public class StudentPagedController {

    private final StudentService studentService;

    @Autowired
    public StudentPagedController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping
//    public String readPaginated (Model model,
//                                  @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, value = 3) Pageable pageable) {
//
//        Page<Student> studentPage = studentService.findPaginated(pageable);
//        model.addAttribute("page", studentPage);
//
//        return "student_page";
//    }

    @GetMapping("/json")
    public ResponseEntity<Page<Student>> read(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        final Page<Student> studentPage = studentService.findPaginated(pageable);
        return ResponseEntity.ok(studentPage);
    }

    @GetMapping
    public String studentsPaged(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);

        Page<Student> studentPage = studentService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("page", studentPage);

        int totalPages = studentPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "student_page";
    }

    @GetMapping("/paged")
    public String studentsReadPage(
            Model model,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 3) Pageable pageable) {

        Page<Student> studentPage = studentService.findPaginated(pageable);

        model.addAttribute("page", studentPage);

        return "student_page_v2";
    }
}
