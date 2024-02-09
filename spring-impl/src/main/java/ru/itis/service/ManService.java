package ru.itis.service;

import ru.itis.dto.request.ManRequest;
import ru.itis.dto.response.ManResponse;

import java.util.Set;
import java.util.UUID;

public interface ManService {
    ManResponse findById(UUID id);

    Set<ManResponse> getAll();

    void save(ManRequest manRequest);

    void update(ManRequest manRequest);

    void delete(UUID id);

    void setWoman(UUID manId, UUID womanId);

    void deleteWoman(UUID manId, UUID womanId);
}
