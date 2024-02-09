package ru.itis.service.impl;

import liquibase.pro.packaged.M;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.MusicRequest;
import ru.itis.dto.response.MusicResponse;
import ru.itis.exception.ServiceException;
import ru.itis.exception.notsaving.ListenerAlreadyExistException;
import ru.itis.exception.notfound.ListenerNotFoundException;
import ru.itis.exception.notfound.MusicNotFoundException;
import ru.itis.mapper.MusicMapper;
import ru.itis.model.Author;
import ru.itis.model.Music;
import ru.itis.repository.AuthorRepository;
import ru.itis.repository.MusicRepository;
import ru.itis.service.MusicService;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService {
    private final MusicRepository musicRepository;
    private final AuthorRepository authorRepository;
    private final MusicMapper mapper;

    @Override
    public MusicResponse findById(UUID id) {
        return mapper.toResponse(
                musicRepository.findById(id)
                        .orElseThrow(() -> new MusicNotFoundException(id))
        );
    }

    @Override
    public Set<MusicResponse> getAll() {
        return musicRepository.getAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public void save(MusicRequest musicRequest) {
        Optional<Author> author = authorRepository.findByName(musicRequest.authorName());
        Optional<Music> music = musicRepository.findByName(musicRequest.name());
        if (author.isEmpty()){
            throw new ServiceException("Author not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (music.isPresent()){
            throw new ListenerAlreadyExistException(musicRequest.name());
        }
        Music resultMusic = Music.builder()
                .author(author.get())
                .name(musicRequest.name())
                .storageName(musicRequest.storageName() + ".mp4")
                .build();

        musicRepository.save(resultMusic);
    }

    @Override
    public void update(MusicRequest musicRequest) {
        Optional<Music> music = musicRepository.findByName(musicRequest.name());
        if (music.isPresent()) {
            musicRepository.update(music.get());
        } else {
            throw new ListenerNotFoundException(musicRequest.name());
        }
    }

    @Override
    public void delete(UUID id) {
        if (musicRepository.findById(id).isPresent()) {
            musicRepository.delete(id);
        } else {
            throw new ListenerNotFoundException(id);
        }
    }
}
