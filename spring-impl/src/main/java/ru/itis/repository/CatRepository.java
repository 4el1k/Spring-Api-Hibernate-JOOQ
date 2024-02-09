package ru.itis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.model.jpa.Cat;

import java.util.Optional;
import java.util.UUID;

public interface CatRepository extends CrudRepository<Cat, UUID> {
    @Query("SELECT cat FROM Cat " +
            "cat JOIN FETCH cat.owner owner " +
            "WHERE cat.id = :id")
    Optional<Cat> getCatByIdWithGrandmother(@Param("id") UUID id);

    Optional<Cat> findByAlias(String alias);

}

