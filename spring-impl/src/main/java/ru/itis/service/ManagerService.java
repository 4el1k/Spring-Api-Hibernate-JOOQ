package ru.itis.service;

import ru.itis.dto.request.ManagerRequest;
import ru.itis.dto.response.ManagerResponse;

import java.util.Set;
import java.util.UUID;

public interface ManagerService {
    ManagerResponse findById(UUID id);

    Set<ManagerResponse> getAll();

    void save(ManagerRequest managerRequest);

    void update(ManagerRequest managerRequest);

    void delete(UUID id);

    void setAuthor(UUID managerId, UUID authorId);

    void deleteAuthor(UUID managerId, UUID authorId);
}
