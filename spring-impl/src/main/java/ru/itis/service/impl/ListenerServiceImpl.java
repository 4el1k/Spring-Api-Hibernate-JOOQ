package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.ListenerRequest;
import ru.itis.dto.response.ListenerResponse;
import ru.itis.exception.notsaving.ListenerAlreadyExistException;
import ru.itis.exception.notfound.ListenerNotFoundException;
import ru.itis.mapper.ListenerMapper;
import ru.itis.model.Listener;
import ru.itis.repository.ListenerRepository;
import ru.itis.service.ListenerService;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListenerServiceImpl implements ListenerService {
    private final ListenerRepository repository;
    private final ListenerMapper mapper;

    @Override
    public ListenerResponse findById(UUID id) {
        return mapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() -> new ListenerNotFoundException(id))
        );
    }

    @Override
    public Set<ListenerResponse> getAll() {
        return repository.getAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public void save(ListenerRequest listenerRequest) {
        Listener listener = mapper.toListener(listenerRequest);
        if (repository.findByName(listener.getName()).isEmpty()) {
            repository.save(listener);
        } else {
            throw new ListenerAlreadyExistException(listener.getName());
        }
    }

    @Override
    public void update(ListenerRequest listenerRequest) {
        Listener listener = mapper.toListener(listenerRequest);
        if (repository.findByName(listener.getName()).isPresent()) {
            repository.update(listener);
        } else {
            throw new ListenerNotFoundException(listener.getName());
        }
    }

    @Override
    public void delete(UUID id) {
        if (repository.findById(id).isPresent()) {
            repository.delete(id);
        } else {
            throw new ListenerNotFoundException(id);
        }
    }

    @Override
    public void updatePlaylist(UUID listenerId, UUID musicId) {
        if (repository.findById(listenerId).isPresent()) {
            repository.updatePlaylist(listenerId, musicId);
        } else {
            throw new ListenerNotFoundException(listenerId);
        }
    }

    @Override
    public void deleteMusicFromPlaylist(UUID listenerId, UUID musicId) {
        if (repository.findById(listenerId).isPresent()) {
            repository.deleteMusicFromPlaylist(listenerId, musicId);
        } else {
            throw new ListenerNotFoundException(listenerId);
        }
    }
}
