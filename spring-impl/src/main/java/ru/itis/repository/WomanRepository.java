package ru.itis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.model.jpa.Woman;

import java.util.Optional;
import java.util.UUID;

public interface WomanRepository extends CrudRepository<Woman, UUID> {
    @Query("SELECT woman FROM Woman " +
            "woman LEFT JOIN FETCH woman.husband hs " +
            "WHERE woman.id = :id")
    Optional<Woman> getWomanByIdWithHusband(@Param("id") UUID id);

    Optional<Woman> findByFirstName(String firstName);
}
