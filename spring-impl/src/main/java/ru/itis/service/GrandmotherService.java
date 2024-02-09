package ru.itis.service;

import ru.itis.dto.request.GrandmotherRequest;
import ru.itis.dto.response.GrandmotherResponse;

import java.util.Set;
import java.util.UUID;

public interface GrandmotherService {
    GrandmotherResponse findById(UUID id);

    Set<GrandmotherResponse> getAll();

    void save(GrandmotherRequest grandmotherRequest);

    void update(GrandmotherRequest grandmotherRequest);

    void delete(UUID id);

    void addCat(UUID grandmotherId, UUID catId);

    void deleteCat(UUID grandmotherId, UUID catId);
}
