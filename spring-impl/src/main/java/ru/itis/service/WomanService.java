package ru.itis.service;

import ru.itis.dto.request.ManRequest;
import ru.itis.dto.request.WomanRequest;
import ru.itis.dto.response.ManResponse;
import ru.itis.dto.response.WomanResponse;

import java.util.Set;
import java.util.UUID;

public interface WomanService {
    WomanResponse findById(UUID id);

    Set<WomanResponse> getAll();

    void save(WomanRequest womanRequest);

    void update(WomanRequest womanRequest);

    void delete(UUID id);

    void setMan(UUID womanID, UUID manId);

    void deleteMan(UUID womanID, UUID manId);
}
