package ru.itis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.model.jpa.Course;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends CrudRepository<Course, UUID> {
    @Query("SELECT course FROM Course " +
            "course JOIN FETCH course.students cs " +
            "WHERE course.id = :id")
    Optional<Course> getCourseByIdWithStudents(@Param("id") UUID id);

    Optional<Course> findByName(String name);

}
