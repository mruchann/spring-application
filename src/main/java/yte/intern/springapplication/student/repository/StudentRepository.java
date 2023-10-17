package yte.intern.springapplication.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yte.intern.springapplication.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
