package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.itis.api.ListenerApi;
import ru.itis.dto.request.ListenerRequest;
import ru.itis.dto.response.ListenerResponse;
import ru.itis.service.ListenerService;

import java.util.Set;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ListenerController implements ListenerApi {
    private final ListenerService service;

    @Override
    public ListenerResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Set<ListenerResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void save(ListenerRequest listenerRequest) {
        service.save(listenerRequest);
    }

    @Override
    public void update(ListenerRequest listenerRequest) {
        service.update(listenerRequest);
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }

    @Override
    public void updatePlaylist(UUID listenerId, UUID musicId) {
        service.updatePlaylist(listenerId, musicId);
    }
}
