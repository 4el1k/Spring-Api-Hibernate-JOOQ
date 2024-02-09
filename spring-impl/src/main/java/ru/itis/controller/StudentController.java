package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.itis.api.StudentApi;
import ru.itis.dto.request.CourseRequest;
import ru.itis.dto.request.StudentRequest;
import ru.itis.dto.response.CourseResponse;
import ru.itis.dto.response.StudentResponse;
import ru.itis.service.StudentService;

import javax.print.DocFlavor;
import java.util.Set;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class StudentController implements StudentApi {
    private final StudentService service;


    @Override
    public StudentResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Set<StudentResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void save(StudentRequest studentRequest) {
        service.save(studentRequest);
    }

    @Override
    public void update(StudentRequest studentRequest) {
        service.update(studentRequest);
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }

    @Override
    public void addCourse(UUID studentId, UUID courseId) {
        service.addCourse(studentId, courseId);
    }

    @Override
    public void deleteCourse(UUID studentId, UUID courseId) {
        service.deleteCourse(studentId, courseId);
    }
}
