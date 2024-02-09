package ru.itis.exception.notfound;

import java.util.UUID;

public class CatNotFoundException extends NotFoundException {
    public CatNotFoundException(String name) {
        super("Is entity with name = %s - not found".formatted(name));
    }

    public CatNotFoundException(UUID id) {
        super("Is entity with id = %s - not found".formatted(id));
    }
}
