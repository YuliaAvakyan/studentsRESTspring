package studentsrestproj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.service.MarkService;

import java.util.List;

//@RestController
public class StudentRestController {

    private final MarkService markService;

    @Autowired
    public StudentRestController(MarkService markService) {
        this.markService = markService;
    }

//    @GetMapping(value = "/marks")
//    public ResponseEntity<List<Marks>> read() {
//        final List<Marks> marks = markService.readAll();
//
//        return marks != null &&  !marks.isEmpty()
//                ? new ResponseEntity<>(marks, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    @GetMapping("/posts")
//    public List<Marks> getAllPosts() {
//        return markService.readAll();
//    }
}
