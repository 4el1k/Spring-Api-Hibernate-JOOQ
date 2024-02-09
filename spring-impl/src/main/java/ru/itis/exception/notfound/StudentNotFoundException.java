package ru.itis.exception.notfound;

import java.util.UUID;

public class StudentNotFoundException extends NotFoundException {
    public StudentNotFoundException(String name) {
        super("Is entity with name = %s - not found".formatted(name));
    }

    public StudentNotFoundException(UUID id) {
        super("Is entity with id = %s - not found".formatted(id));
    }
}
