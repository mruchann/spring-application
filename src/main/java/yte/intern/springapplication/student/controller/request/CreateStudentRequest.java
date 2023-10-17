package yte.intern.springapplication.student.controller.request;

import jakarta.validation.constraints.*;
import yte.intern.springapplication.student.entity.Student;

public record CreateStudentRequest(
        @NotBlank
        String name,

        @NotBlank
        String surname,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 11, max = 11)
        String nationalID,

        @NotBlank
        @Size(min = 7, max = 7)
        String studentID
) {
        public Student toStudent() {
                return new Student(name, surname, email, nationalID, studentID);
        }
}
