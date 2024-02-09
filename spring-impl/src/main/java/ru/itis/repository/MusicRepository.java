package ru.itis.repository;

import ru.itis.model.Music;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface MusicRepository {
    Optional<Music> findById(UUID id);

    Set<Music> getAll();

    void save(Music music);

    void update(Music music);

    void delete(UUID id);

    Optional<Music> findByName(String name);
}
