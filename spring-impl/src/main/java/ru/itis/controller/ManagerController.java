package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.itis.api.ManagerApi;
import ru.itis.dto.request.ManagerRequest;
import ru.itis.dto.response.ManagerResponse;
import ru.itis.service.ManagerService;

import java.util.Set;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ManagerController implements ManagerApi {
    private final ManagerService service;

    @Override
    public ManagerResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Set<ManagerResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void save(ManagerRequest managerRequest) {
        service.save(managerRequest);
    }

    @Override
    public void update(ManagerRequest managerRequest) {
        service.update(managerRequest);
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }

    @Override
    public void setAuthor(UUID managerId, UUID authorId) {
        service.setAuthor(managerId, authorId);
    }

    @Override
    public void deleteAuthor(UUID managerId, UUID authorId) {
        service.deleteAuthor(managerId, authorId);
    }
}
