package yte.intern.springapplication.student.controller.response;

public record CreateStudentResponse(
        String name,

        String surname,

        String email,

        String nationalID,

        String studentID
) {

}