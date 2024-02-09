package ru.itis.controller;

import lombok.AllArgsConstructor;
import org.hibernate.hql.internal.ast.tree.AggregatedSelectExpression;
import org.springframework.stereotype.Controller;
import ru.itis.api.CourseApi;
import ru.itis.dto.request.CourseRequest;
import ru.itis.dto.response.CourseResponse;
import ru.itis.service.CourseService;

import java.util.Set;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class CourseController implements CourseApi {
    private final CourseService service;

    @Override
    public CourseResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Set<CourseResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void save(CourseRequest courseRequest) {
        service.save(courseRequest);
    }

    @Override
    public void update(CourseRequest courseRequest) {
        service.update(courseRequest);
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }
}
