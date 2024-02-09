package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.itis.api.AuthorApi;
import ru.itis.dto.request.AuthorRequest;
import ru.itis.dto.response.AuthorResponse;
import ru.itis.service.AuthorService;

import java.util.Set;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class AuthorController implements AuthorApi {
    private final AuthorService service;

    @Override
    public AuthorResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Set<AuthorResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void save(AuthorRequest authorRequest) {
        service.save(authorRequest);
    }

    @Override
    public void update(AuthorRequest authorRequest) {
        service.update(authorRequest);
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }
}
