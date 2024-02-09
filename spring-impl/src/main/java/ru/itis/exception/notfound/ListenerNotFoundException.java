package ru.itis.exception.notfound;

import java.util.UUID;

public class ListenerNotFoundException extends NotFoundException {
    public ListenerNotFoundException(String name) {
        super("Listener with name = %s - not found".formatted(name));
    }

    public ListenerNotFoundException(UUID id) {
        super("Listener with id = %s - not found".formatted(id));
    }
}
