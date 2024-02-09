package ru.itis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.model.jpa.Student;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends CrudRepository<Student, UUID> {
    @Query("SELECT student FROM Student " +
            "student JOIN FETCH student.courses cs " +
            "WHERE student.id = :id")
    Optional<Student> getStudentByIdWithCourses(@Param("id") UUID id);

    Optional<Student> findByName(String name);
}
