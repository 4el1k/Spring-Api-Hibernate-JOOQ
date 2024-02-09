package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.itis.api.MusicApi;
import ru.itis.dto.request.MusicRequest;
import ru.itis.dto.response.MusicResponse;
import ru.itis.service.MusicService;

import java.util.Set;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MusicController implements MusicApi {
    private final MusicService service;

    @Override
    public MusicResponse getById(UUID id) {
        return service.findById(id);
    }

    @Override
    public Set<MusicResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void save(MusicRequest musicRequest) {
        service.save(musicRequest);
    }

    @Override
    public void update(MusicRequest musicRequest) {
        service.update(musicRequest);
    }

    @Override
    public void delete(UUID id) {
        service.delete(id);
    }
}
