package ru.itis.exception.notfound;

import java.util.UUID;

public class WomanNotFoundException extends NotFoundException {
    public WomanNotFoundException(String name) {
        super("Is entity with name = %s - not found".formatted(name));
    }

    public WomanNotFoundException(UUID id) {
        super("Is entity with id = %s - not found".formatted(id));
    }
}
