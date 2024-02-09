package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.itis.api.ManApi;
import ru.itis.dto.request.ManRequest;
import ru.itis.dto.request.WomanRequest;
import ru.itis.dto.response.ManResponse;
import ru.itis.dto.response.WomanResponse;
import ru.itis.service.ManService;

import java.util.Set;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ManController implements ManApi {
    private final ManService service;

    @Override
    public ManResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Set<ManResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void save(ManRequest manRequest) {
        service.save(manRequest);
    }

    @Override
    public void update(ManRequest manRequest) {
        service.update(manRequest);
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }

    @Override
    public void addWoman(UUID womanId, UUID manId) {
        service.setWoman(manId, womanId);
    }

    @Override
    public void deleteWoman(UUID womanId, UUID manId) {
        service.deleteWoman(manId, womanId);
    }
}
