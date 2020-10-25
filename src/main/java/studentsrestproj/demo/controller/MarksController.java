package studentsrestproj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import studentsrestproj.demo.model.Marks;
import studentsrestproj.demo.model.Student;
import studentsrestproj.demo.service.MarksService;
import studentsrestproj.demo.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MarksController {

    private final StudentService studentService;
    private final MarksService marksService;

    @Autowired
    public MarksController(StudentService studentService, MarksService marksService) {
        this.studentService = studentService;
        this.marksService = marksService;
    }

    @GetMapping("/student/{id}/marks")
    public ResponseEntity<List<Marks>> getMarksByStudent(@PathVariable(name = "id") Long studentId) {
        return ResponseEntity.ok(marksService.findByStudentId(studentId));
    }

    @PutMapping("/student/{id}/marks/{m_id}")
    public ResponseEntity<Marks> updateMark(@PathVariable (value = "id") Long studId,
                                            @PathVariable (value = "m_id") Long markId,
                                            @RequestBody Marks newMark) {
        return ResponseEntity.ok(marksService.update(newMark, markId));
    }

//    @PutMapping("/posts/{postId}/comments/{commentId}")
//    public Marks updateMark1(@PathVariable Long studId,
//                                 @PathVariable Long markId,
//                                 @Valid @RequestBody Marks newMark) {
//        if(!postRepository.existsById(postId)) {
//            throw new ResourceNotFoundException("PostId " + postId + " not found");
//        }
//
//        return commentRepository.findById(commentId).map(comment -> {
//            comment.setText(commentRequest.getText());
//            return commentRepository.save(comment);
//        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
//    }


}
