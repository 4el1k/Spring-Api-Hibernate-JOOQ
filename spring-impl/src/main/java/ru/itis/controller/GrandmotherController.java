package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.itis.api.GrandmotherApi;
import ru.itis.dto.request.GrandmotherRequest;
import ru.itis.dto.response.GrandmotherResponse;
import ru.itis.service.GrandmotherService;

import java.util.Set;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class GrandmotherController implements GrandmotherApi {
    private final GrandmotherService service;

    @Override
    public GrandmotherResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Set<GrandmotherResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void save(GrandmotherRequest grandmotherRequest) {
        service.save(grandmotherRequest);
    }

    @Override
    public void update(GrandmotherRequest grandmotherRequest) {
        service.update(grandmotherRequest);
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }

    @Override
    public void addCat(UUID grandmotherId, UUID catId) {
        service.addCat(grandmotherId, catId);
    }

    @Override
    public void deleteCat(UUID grandmotherId, UUID catId) {
        service.deleteCat(grandmotherId, catId);
    }
}
