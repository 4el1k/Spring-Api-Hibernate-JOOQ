package ru.itis.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.model.jpa.Man;

import java.util.Optional;
import java.util.UUID;

public interface ManRepository extends PagingAndSortingRepository<Man, UUID> {
    @Query("SELECT man FROM Man " +
            "man LEFT JOIN FETCH man.wife wf " +
            "WHERE man.id = :id")
    Optional<Man> getManByIdWithWife(@Param("id") UUID id);

    Optional<Man> findByFirstName(String firstName);
}
