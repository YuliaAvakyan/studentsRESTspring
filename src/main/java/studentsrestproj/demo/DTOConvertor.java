//package studentsrestproj.demo;
//
//import org.modelmapper.ModelMapper;
//import studentsrestproj.demo.DTO.StudentDTO;
//import studentsrestproj.demo.model.Student;
//
//public class DTOConvertor {
//
//    private Student student;
//    private StudentDTO studentDTO;
//
//    private ModelMapper modelMapper;
//
//    private Student convertToEntity(StudentDTO studentDTO) throws ParseException {
//        Student student = modelMapper.map(studentDTO, Student.class);
//        student.setSubmissionDate(studentDTO.getSubmissionDateConverted(
//                userService.getCurrentUser().getPreference().getTimezone()));
//
//        if (studentDTO.getId() != null) {
//            Student oldPost = postService.getPostById(studentDTO.getId());
//            student.setRedditID(oldPost.getRedditID());
//            student.setSent(oldPost.isSent());
//        }
//        return student;
//    }
//
//    private StudentDTO convertToDto(Student student) {
//        StudentDTO postDto = modelMapper.map(student, StudentDTO.class);
//        postDto.setSubmissionDate(post.getSubmissionDate(),
//                userService.getCurrentUser().getPreference().getTimezone());
//        return postDto;
//    }
//}
