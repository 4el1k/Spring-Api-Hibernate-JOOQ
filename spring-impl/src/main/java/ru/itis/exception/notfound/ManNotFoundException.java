package ru.itis.exception.notfound;

import java.util.UUID;

public class ManNotFoundException extends NotFoundException {
    public ManNotFoundException(String name) {
        super("Is entity with name = %s - not found".formatted(name));
    }

    public ManNotFoundException(UUID id) {
        super("Is entity with id = %s - not found".formatted(id));
    }
}
