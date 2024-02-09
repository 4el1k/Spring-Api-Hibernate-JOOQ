package ru.itis.service;

import ru.itis.dto.request.MusicRequest;
import ru.itis.dto.response.MusicResponse;

import java.util.Set;
import java.util.UUID;

public interface MusicService {
    MusicResponse findById(UUID id);

    Set<MusicResponse> getAll();

    void save(MusicRequest musicRequest);

    void update(MusicRequest musicRequest);

    void delete(UUID id);
}
