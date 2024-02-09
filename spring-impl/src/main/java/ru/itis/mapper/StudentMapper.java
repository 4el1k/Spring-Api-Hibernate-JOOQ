package ru.itis.mapper;

import org.mapstruct.Mapper;
import ru.itis.dto.request.GrandmotherRequest;
import ru.itis.dto.request.StudentRequest;
import ru.itis.dto.response.GrandmotherResponse;
import ru.itis.dto.response.StudentResponse;
import ru.itis.model.jpa.Grandmother;
import ru.itis.model.jpa.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentRequest studentRequest);

    StudentResponse toResponse(Student student);
}
