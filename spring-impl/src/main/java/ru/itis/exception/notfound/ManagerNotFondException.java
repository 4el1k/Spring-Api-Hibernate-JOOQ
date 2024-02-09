package ru.itis.exception.notfound;

import java.util.UUID;

public class ManagerNotFondException extends NotFoundException {
    public ManagerNotFondException(String name) {
        super("Manager with name = %s - not found".formatted(name));
    }
    public ManagerNotFondException(UUID id) {
        super("Manager with id = %s - not found".formatted(id));
    }
}
