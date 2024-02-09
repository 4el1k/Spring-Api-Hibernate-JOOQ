package ru.itis.service;

import ru.itis.dto.request.CatRequest;
import ru.itis.dto.request.CourseRequest;
import ru.itis.dto.response.CourseResponse;

import java.util.Set;
import java.util.UUID;

public interface CourseService {
    CourseResponse findById(UUID id);

    Set<CourseResponse> getAll();

    void save(CourseRequest courseRequest);

    void update(CourseRequest courseRequest);

    void delete(UUID id);
}
