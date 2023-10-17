package yte.intern.springapplication.student.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.student.controller.request.CreateStudentRequest;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.service.StudentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    @PostMapping
    public MessageResponse createStudent(@RequestBody @Valid CreateStudentRequest createStudentRequest) {
        Student student = createStudentRequest.toStudent();
        return studentService.createStudent(student);
    }
}
