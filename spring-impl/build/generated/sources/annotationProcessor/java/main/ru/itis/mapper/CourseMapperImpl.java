package ru.itis.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.dto.request.CourseRequest;
import ru.itis.dto.response.CourseResponse;
import ru.itis.model.jpa.Course;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-04T20:23:56+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public Course toCourse(CourseRequest courseRequest) {
        if ( courseRequest == null ) {
            return null;
        }

        Course.CourseBuilder<?, ?> course = Course.builder();

        course.name( courseRequest.name() );

        return course.build();
    }

    @Override
    public CourseResponse toResponse(Course course) {
        if ( course == null ) {
            return null;
        }

        String name = null;

        name = course.getName();

        CourseResponse courseResponse = new CourseResponse( name );

        return courseResponse;
    }
}
