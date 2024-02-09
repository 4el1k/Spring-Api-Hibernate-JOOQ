package ru.itis.exception.notfound;

import java.util.UUID;

public class MusicNotFoundException extends NotFoundException {
    public MusicNotFoundException(String name) {
        super("Music with name = %s - not found".formatted(name));
    }

    public MusicNotFoundException(UUID id) {
        super("Music with id = %s - not found".formatted(id));
    }
}
