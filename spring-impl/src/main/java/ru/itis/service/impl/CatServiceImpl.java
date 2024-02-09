package ru.itis.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.CatRequest;
import ru.itis.dto.response.CatResponse;
import ru.itis.exception.notfound.AuthorNotFoundException;
import ru.itis.exception.notfound.CatNotFoundException;
import ru.itis.exception.notsaving.AuthorAlreadyExistException;
import ru.itis.exception.notsaving.CatAlreadyExistException;
import ru.itis.mapper.CatMapper;
import ru.itis.model.Author;
import ru.itis.model.jpa.Cat;
import ru.itis.repository.CatRepository;
import ru.itis.service.CatService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatServiceImpl implements CatService {
    private final CatRepository repository;
    private final CatMapper mapper;

    @Override
    public CatResponse findById(UUID id) {
        return mapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() -> new CatNotFoundException(id))
        );
    }

    @Override
    public Set<CatResponse> getAll() {
        Iterator<Cat> iterator = repository.findAll().iterator();
        Set<CatResponse> result = new HashSet<>();
        while (iterator.hasNext()){
            result.add(
                    mapper.toResponse(iterator.next())
            );
        }

        return result;
    }

    @Override
    public void save(CatRequest catRequest) {
        Cat cat = mapper.toCat(catRequest);
        if (repository.findByAlias(cat.getAlias()).isEmpty()) {
            repository.save(cat);
        } else {
            throw new CatAlreadyExistException(cat.getAlias());
        }
    }

    @Override
    public void update(CatRequest catRequest) {
        Cat cat = mapper.toCat(catRequest);
        if (repository.findByAlias(cat.getAlias()).isPresent()) {
            repository.save(cat);
        } else {
            throw new CatAlreadyExistException(cat.getAlias());
        }
    }

    @Override
    public void delete(UUID id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new CatNotFoundException(id);
        }
    }
}
