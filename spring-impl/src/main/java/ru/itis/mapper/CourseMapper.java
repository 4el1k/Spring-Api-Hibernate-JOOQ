package ru.itis.mapper;

import org.mapstruct.Mapper;
import ru.itis.dto.request.CourseRequest;
import ru.itis.dto.request.GrandmotherRequest;
import ru.itis.dto.response.CourseResponse;
import ru.itis.dto.response.GrandmotherResponse;
import ru.itis.model.jpa.Course;
import ru.itis.model.jpa.Grandmother;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toCourse(CourseRequest courseRequest);

    CourseResponse toResponse(Course course);
}
