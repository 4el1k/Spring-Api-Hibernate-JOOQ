package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.model.jpa.Grandmother;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Transactional
public interface GrandmotherRepository extends CrudRepository<Grandmother, UUID> {
    @Query("SELECT grm FROM Grandmother " +
            "grm JOIN FETCH grm.cats cs " +
            "WHERE grm.id = :id")
    Optional<Grandmother> getGrandmotherByIdWithCats(@Param("id") UUID id);

    Optional<Grandmother> findByName(String name);
}
