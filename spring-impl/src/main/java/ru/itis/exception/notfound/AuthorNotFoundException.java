package ru.itis.exception.notfound;

import java.util.UUID;

public class AuthorNotFoundException extends NotFoundException {
    public AuthorNotFoundException(String name) {
        super("Author with name = %s - not found".formatted(name));
    }

    public AuthorNotFoundException(UUID id) {
        super("Author with id = %s - not found".formatted(id));
    }
}
