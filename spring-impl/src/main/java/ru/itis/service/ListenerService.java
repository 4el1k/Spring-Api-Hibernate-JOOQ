package ru.itis.service;

import ru.itis.dto.request.ListenerRequest;
import ru.itis.dto.response.ListenerResponse;

import java.util.Set;
import java.util.UUID;

public interface ListenerService {
    ListenerResponse findById(UUID id);

    Set<ListenerResponse> getAll();

    void save(ListenerRequest listenerRequest);

    void update(ListenerRequest listenerRequest);

    void delete(UUID id);

    void updatePlaylist(UUID listenerId, UUID musicId);

    void deleteMusicFromPlaylist(UUID listenerId, UUID musicId);
}
