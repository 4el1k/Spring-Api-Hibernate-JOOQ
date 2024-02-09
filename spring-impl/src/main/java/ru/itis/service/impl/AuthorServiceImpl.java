package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.AuthorRequest;
import ru.itis.dto.response.AuthorResponse;
import ru.itis.exception.notfound.AuthorNotFoundException;
import ru.itis.exception.notsaving.AuthorAlreadyExistException;
import ru.itis.mapper.AuthorMapper;
import ru.itis.model.Author;
import ru.itis.repository.AuthorRepository;
import ru.itis.service.AuthorService;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    @Override
    public AuthorResponse findById(UUID id) {
        return mapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() -> new AuthorNotFoundException(id))
        );
    }

    @Override
    public Set<AuthorResponse> getAll() {
        return repository.getAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public void save(AuthorRequest authorRequest) {
        Author author = mapper.toAuthor(authorRequest);
        if (repository.findByName(author.getName()).isEmpty()) {
            repository.save(author);
        } else {
            throw new AuthorAlreadyExistException(author.getName());
        }
    }

    @Override
    public void update(AuthorRequest authorRequest) {
        Author author = mapper.toAuthor(authorRequest);
        if (repository.findByName(author.getName()).isPresent()) {
            repository.update(author);
        } else {
            throw new AuthorAlreadyExistException(author.getName());
        }

    }

    @Override
    public void delete(UUID id) {
        if (repository.findById(id).isPresent()) {
            repository.delete(id);
        } else {
            throw new AuthorNotFoundException(id);
        }
    }
}
