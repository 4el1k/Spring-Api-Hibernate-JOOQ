package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.CourseRequest;
import ru.itis.dto.response.CourseResponse;
import ru.itis.exception.notfound.CourseNotFoundException;
import ru.itis.exception.notfound.GrandmotherNotFoundException;
import ru.itis.exception.notsaving.CourseAlreadyExistException;
import ru.itis.mapper.CourseMapper;
import ru.itis.model.jpa.Course;
import ru.itis.repository.CourseRepository;
import ru.itis.service.CourseService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;
    private final CourseMapper mapper;

    @Override
    public CourseResponse findById(UUID id) {
        return mapper.toResponse(
                repository.getCourseByIdWithStudents(id)
                        .orElseThrow(() -> new CourseNotFoundException(id))
        );
    }

    @Override
    public Set<CourseResponse> getAll() {
        Iterator<Course> iterator = repository.findAll().iterator();
        Set<CourseResponse> result = new HashSet<>();
        while (iterator.hasNext()){
            result.add(
                    mapper.toResponse(iterator.next())
            );
        }

        return result;
    }

    @Override
    public void save(CourseRequest courseRequest) {
        Course course = mapper.toCourse(courseRequest);
        if (repository.findByName(course.getName()).isEmpty()) {
            repository.save(course);
        } else {
            throw new CourseAlreadyExistException(course.getName());
        }
    }

    @Override
    public void update(CourseRequest courseRequest) {
        Course course = mapper.toCourse(courseRequest);
        if (repository.findByName(course.getName()).isEmpty()) {
            repository.save(course);
        } else {
            throw new CourseAlreadyExistException(course.getName());
        }
    }

    @Override
    public void delete(UUID id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new GrandmotherNotFoundException(id);
        }
    }
}
