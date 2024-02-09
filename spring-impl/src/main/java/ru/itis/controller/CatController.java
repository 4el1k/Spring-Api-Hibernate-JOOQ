package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.itis.api.CatApi;
import ru.itis.dto.request.CatRequest;
import ru.itis.dto.response.CatResponse;
import ru.itis.service.CatService;

import java.util.Set;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class CatController implements CatApi {
    private final CatService service;

    @Override
    public CatResponse getById(UUID id) {
        System.out.println("controller: id = " + id);
        return service.findById(id);
    }

    @Override
    public Set<CatResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void save(CatRequest catRequest) {
        service.save(catRequest);
    }

    @Override
    public void update(CatRequest catRequest) {
        service.update(catRequest);
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }
}
