package yte.intern.springapplication.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.springapplication.common.BaseEntity;

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
}