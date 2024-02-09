package ru.itis.repository;

import ru.itis.model.Manager;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ManagerRepository {
    Optional<Manager> findById(UUID id);

    Set<Manager> getAll();

    void save(Manager manager);

    void update(Manager manager);

    void delete(UUID id);

    Optional<Manager> findByName(String name);

    void setAuthor(UUID managerId, UUID authorId);

    void deleteAuthor(UUID managerId, UUID authorId);
}
