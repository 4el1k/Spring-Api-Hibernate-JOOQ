package ru.itis.service;

import ru.itis.dto.request.AuthorRequest;
import ru.itis.dto.request.CatRequest;
import ru.itis.dto.response.AuthorResponse;
import ru.itis.dto.response.CatResponse;

import java.util.Set;
import java.util.UUID;

public interface CatService {
    CatResponse findById(UUID id);

    Set<CatResponse> getAll();

    void save(CatRequest catRequest);

    void update(CatRequest catRequest);

    void delete(UUID id);
}
