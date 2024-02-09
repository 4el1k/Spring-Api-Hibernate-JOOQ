package ru.itis.service;

import ru.itis.dto.request.AuthorRequest;
import ru.itis.dto.response.AuthorResponse;

import java.util.Set;
import java.util.UUID;

public interface AuthorService {
    AuthorResponse findById(UUID id);

    Set<AuthorResponse> getAll();

    void save(AuthorRequest authorRequest);

    void update(AuthorRequest authorRequest);

    void delete(UUID id);
}
