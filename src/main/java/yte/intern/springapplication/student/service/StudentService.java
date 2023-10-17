package yte.intern.springapplication.student.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.common.response.MessageType;
import yte.intern.springapplication.student.controller.request.CreateStudentRequest;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public MessageResponse createStudent(Student student) {
        studentRepository.save(student);
        return new MessageResponse(
                "Student has been created successfully!!!",
                MessageType.SUCCESS
        );
    }

    public Student findStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
