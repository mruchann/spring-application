package yte.intern.springapplication.student.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.student.controller.request.CreateStudentRequest;
import yte.intern.springapplication.student.controller.request.UpdateStudentRequest;
import yte.intern.springapplication.student.controller.response.CreateStudentResponse;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
@Validated
public class StudentController {

    private final StudentService studentService;
    @PostMapping
    public MessageResponse createStudent(@RequestBody @Valid CreateStudentRequest createStudentRequest) {
        Student student = createStudentRequest.toStudent();
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public CreateStudentResponse getStudentById(@NotNull @PathVariable Long id) {
        Student student = studentService.findStudentById(id);
        return student.toCreateStudentResponse();
    }

    @GetMapping
    public List<CreateStudentResponse> getStudents() {
        List<Student> students = studentService.getStudents();
        return students.stream()
                .map(Student::toCreateStudentResponse)
                .toList();
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteStudent(@NotNull @PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public MessageResponse updateStudent(
            @NotNull @PathVariable Long id,
            @RequestBody @Valid UpdateStudentRequest updateStudentRequest
    ) {
        return studentService.updateStudent(id, updateStudentRequest);
    }
}
