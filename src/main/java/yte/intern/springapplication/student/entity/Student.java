package yte.intern.springapplication.student.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.springapplication.common.BaseEntity;
import yte.intern.springapplication.student.controller.request.UpdateStudentRequest;
import yte.intern.springapplication.student.controller.response.CreateStudentResponse;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Student extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String nationalID;
    private String studentID;

    public CreateStudentResponse toCreateStudentResponse() {
        return new CreateStudentResponse(name, surname, email, nationalID, studentID);
    }

    public void update(UpdateStudentRequest updateStudentRequest) {
        this.name = updateStudentRequest.name();
        this.surname = updateStudentRequest.surname();
        this.email = updateStudentRequest.email();
        this.studentID = updateStudentRequest.studentID();
    }
}
