package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.ManagerRequest;
import ru.itis.dto.response.ManagerResponse;
import ru.itis.exception.notfound.ListenerNotFoundException;
import ru.itis.exception.notfound.ManagerNotFondException;
import ru.itis.exception.notsaving.ListenerAlreadyExistException;
import ru.itis.exception.notsaving.ManagerAlreadyExistException;
import ru.itis.mapper.ListenerMapper;
import ru.itis.mapper.ManagerMapper;
import ru.itis.model.Listener;
import ru.itis.model.Manager;
import ru.itis.repository.ListenerRepository;
import ru.itis.repository.ManagerRepository;
import ru.itis.service.ManagerService;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository repository;
    private final ManagerMapper mapper;

    @Override
    public ManagerResponse findById(UUID id) {
        return mapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() -> new ManagerNotFondException(id))
        );
    }

    @Override
    public Set<ManagerResponse> getAll() {
        return repository.getAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public void save(ManagerRequest managerRequest) {
        Manager manager = mapper.toManager(managerRequest);
        if (repository.findByName(manager.getName()).isEmpty()) {
            repository.save(manager);
        } else {
            throw new ManagerAlreadyExistException(manager.getName());
        }
    }

    @Override
    public void update(ManagerRequest managerRequest) {
        Manager manager = mapper.toManager(managerRequest);
        if (repository.findByName(manager.getName()).isPresent()) {
            repository.update(manager);
        } else {
            throw new ManagerNotFondException(manager.getName());
        }

    }

    @Override
    public void delete(UUID id) {
        if (repository.findById(id).isPresent()) {
            repository.delete(id);
        } else {
            throw new ManagerNotFondException(id);
        }
    }

    @Override
    public void setAuthor(UUID managerId, UUID authorId) {
        if (repository.findById(managerId).isPresent()) {
            repository.setAuthor(managerId, authorId);
        } else {
            throw new ManagerNotFondException(managerId);
        }
    }

    @Override
    public void deleteAuthor(UUID managerId, UUID authorId) {
        if (repository.findById(managerId).isPresent()) {
            repository.deleteAuthor(managerId, authorId);
        } else {
            throw new ManagerNotFondException(managerId);
        }
    }
}
