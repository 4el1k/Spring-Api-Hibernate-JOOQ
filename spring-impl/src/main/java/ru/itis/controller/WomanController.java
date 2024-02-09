package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.itis.api.WomanApi;
import ru.itis.dto.request.WomanRequest;
import ru.itis.dto.response.WomanResponse;
import ru.itis.service.WomanService;

import java.util.Set;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class WomanController implements WomanApi {
    private final WomanService service;

    @Override
    public WomanResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Set<WomanResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void save(WomanRequest womanRequest) {
        service.save(womanRequest);
    }

    @Override
    public void update(WomanRequest womanRequest) {
        service.update(womanRequest);
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }

    @Override
    public void addMan(UUID womanId, UUID manId) {
        service.setMan(womanId, manId);
    }

    @Override
    public void deleteMan(UUID womanId, UUID manId) {
        service.deleteMan(womanId, manId);
    }
}
