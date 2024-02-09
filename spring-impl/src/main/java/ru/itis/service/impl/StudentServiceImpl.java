package ru.itis.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.StudentRequest;
import ru.itis.dto.response.StudentResponse;
import ru.itis.exception.notfound.GrandmotherNotFoundException;
import ru.itis.exception.notfound.StudentNotFoundException;
import ru.itis.exception.notsaving.CourseAlreadyExistException;
import ru.itis.mapper.StudentMapper;
import ru.itis.model.jpa.Student;
import ru.itis.repository.StudentRepository;
import ru.itis.service.StudentService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Override
    public StudentResponse findById(UUID id) {
        return mapper.toResponse(
                repository.getStudentByIdWithCourses(id)
                        .orElseThrow(() -> new StudentNotFoundException(id))
        );
    }

    @Override
    public Set<StudentResponse> getAll() {
        Iterator<Student> iterator = repository.findAll().iterator();
        Set<StudentResponse> result = new HashSet<>();
        while (iterator.hasNext()){
            result.add(
                    mapper.toResponse(iterator.next())
            );
        }

        return result;
    }

    @Override
    public void save(StudentRequest studentRequest) {
        Student student = mapper.toStudent(studentRequest);
        if (repository.findByName(student.getName()).isPresent()) {
            repository.save(student);
        } else {
            throw new CourseAlreadyExistException(student.getName());
        }
    }

    @Override
    public void update(StudentRequest studentRequest) {
        Student student = mapper.toStudent(studentRequest);
        if (repository.findByName(student.getName()).isEmpty()) {
            repository.save(student);
        } else {
            throw new CourseAlreadyExistException(student.getName());
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

    @Override
    public void addCourse(UUID studentId, UUID courseId) {
        // ToDo
    }

    @Override
    public void deleteCourse(UUID studentId, UUID courseId) {
        // ToDo
    }
}
