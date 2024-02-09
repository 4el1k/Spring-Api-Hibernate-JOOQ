package ru.itis.repository;

import ru.itis.dto.request.ListenerRequest;
import ru.itis.model.Listener;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ListenerRepository {
    Optional<Listener> findById(UUID id);

    Set<Listener> getAll();

    void save(Listener listener);

    void update(Listener listener);

    void delete(UUID id);

    void updatePlaylist(UUID listenerId, UUID musicId);

    void deleteMusicFromPlaylist(UUID listenerId, UUID musicId);

    Optional<Listener> findByName(String name);
}
