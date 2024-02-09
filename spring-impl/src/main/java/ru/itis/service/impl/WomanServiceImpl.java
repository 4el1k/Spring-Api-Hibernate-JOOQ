package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.WomanRequest;
import ru.itis.dto.response.WomanResponse;
import ru.itis.exception.notfound.GrandmotherNotFoundException;
import ru.itis.exception.notfound.WomanNotFoundException;
import ru.itis.exception.notsaving.CourseAlreadyExistException;
import ru.itis.mapper.WomanMapper;
import ru.itis.model.jpa.Woman;
import ru.itis.repository.WomanRepository;
import ru.itis.service.WomanService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WomanServiceImpl implements WomanService {
    private final WomanRepository repository;
    private final WomanMapper mapper;

    @Override
    public WomanResponse findById(UUID id) {
        return mapper.toResponse(repository.getWomanByIdWithHusband(id)
                .orElseThrow(() -> new WomanNotFoundException(id)));
    }

    @Override
    public Set<WomanResponse> getAll() {
        Iterator<Woman> iterator = repository.findAll().iterator();
        Set<WomanResponse> result = new HashSet<>();
        while (iterator.hasNext()) {
            result.add(
                    mapper.toResponse(iterator.next())
            );
        }

        return result;
    }

    @Override
    public void save(WomanRequest womanRequest) {
        Woman woman = mapper.toWoman(womanRequest);
        if (repository.findByFirstName(woman.getFirstName()).isPresent()) {
            repository.save(woman);
        } else {
            throw new CourseAlreadyExistException(woman.getFirstName());
        }
    }

    @Override
    public void update(WomanRequest womanRequest) {
        Woman woman = mapper.toWoman(womanRequest);
        if (repository.findByFirstName(woman.getFirstName()).isEmpty()) {
            repository.save(woman);
        } else {
            throw new CourseAlreadyExistException(woman.getFirstName());
        }
    }

    @Override
    public void delete(UUID id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new GrandmotherNotFoundException(id);
        }
    }

    @Override
    public void setMan(UUID womanID, UUID manId) {
        // ToDo
    }

    @Override
    public void deleteMan(UUID womanID, UUID manId) {
        // ToDo
    }
}
