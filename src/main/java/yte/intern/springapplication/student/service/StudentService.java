package yte.intern.springapplication.student.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.springapplication.common.response.MessageResponse;
import yte.intern.springapplication.common.response.MessageType;
import yte.intern.springapplication.student.controller.request.UpdateStudentRequest;
import yte.intern.springapplication.student.entity.Student;
import yte.intern.springapplication.student.repository.StudentRepository;

import java.util.List;

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

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public MessageResponse deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            return new MessageResponse(
                    "Student could not be found!!!",
                    MessageType.ERROR
            );
        }
        studentRepository.deleteById(id);
        return new MessageResponse(
                "Student has been deleted successfully!!!",
                MessageType.SUCCESS
        );
    }

    @Transactional
    public MessageResponse updateStudent(Long id, UpdateStudentRequest updateStudentRequest) {
        Student student = studentRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new);
        student.update(updateStudentRequest);
        studentRepository.save(student);
        return new MessageResponse(
                "Student has been updated successfully!!!",
                MessageType.SUCCESS
        );
    }
}
