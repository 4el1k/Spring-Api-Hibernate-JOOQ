package ru.itis.repository;

import ru.itis.model.Author;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface AuthorRepository {
    Optional<Author> findById(UUID id);

    Set<Author> getAll();

    void save(Author author);

    void update(Author author);

    void delete(UUID id);

    Optional<Author> findByName(String name);
}
