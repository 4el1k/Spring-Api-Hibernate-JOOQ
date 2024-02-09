package ru.itis.exception.notfound;

import java.util.UUID;

public class CourseNotFoundException extends NotFoundException {
    public CourseNotFoundException(String name) {
        super("Is entity with name = %s - not found".formatted(name));
    }

    public CourseNotFoundException(UUID id) {
        super("Is entity with id = %s - not found".formatted(id));
    }
}
