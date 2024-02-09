package ru.itis.service;

import ru.itis.dto.request.GrandmotherRequest;
import ru.itis.dto.request.StudentRequest;
import ru.itis.dto.response.GrandmotherResponse;
import ru.itis.dto.response.StudentResponse;

import java.util.Set;
import java.util.UUID;

public interface StudentService {
    StudentResponse findById(UUID id);

    Set<StudentResponse> getAll();

    void save(StudentRequest studentRequest);

    void update(StudentRequest studentRequest);

    void delete(UUID id);

    void addCourse(UUID studentId, UUID courseId);

    void deleteCourse(UUID studentId, UUID courseId);
}
