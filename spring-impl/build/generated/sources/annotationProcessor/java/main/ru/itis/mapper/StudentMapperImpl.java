package ru.itis.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.dto.request.StudentRequest;
import ru.itis.dto.response.StudentResponse;
import ru.itis.model.jpa.Student;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-04T20:23:56+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toStudent(StudentRequest studentRequest) {
        if ( studentRequest == null ) {
            return null;
        }

        Student.StudentBuilder<?, ?> student = Student.builder();

        student.name( studentRequest.name() );

        return student.build();
    }

    @Override
    public StudentResponse toResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        String name = null;

        name = student.getName();

        StudentResponse studentResponse = new StudentResponse( name );

        return studentResponse;
    }
}
