package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.ManRequest;
import ru.itis.dto.response.ManResponse;
import ru.itis.exception.notfound.GrandmotherNotFoundException;
import ru.itis.exception.notfound.ManNotFoundException;
import ru.itis.mapper.ManMapper;
import ru.itis.model.jpa.Man;
import ru.itis.repository.ManRepository;
import ru.itis.service.ManService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManServiceImpl implements ManService {
    private final ManRepository repository;
    private final ManMapper mapper;

    @Override
    public ManResponse findById(UUID id) {
        return mapper.toResponse(
                repository.getManByIdWithWife(id)
                        .orElseThrow(() -> new ManNotFoundException(id))
        );
    }

    @Override
    public Set<ManResponse> getAll() {
        Iterator<Man> iterator = repository.findAll().iterator();
        Set<ManResponse> result = new HashSet<>();
        while (iterator.hasNext()){
            result.add(
                    mapper.toResponse(iterator.next())
            );
        }

        return result;
    }

    @Override
    public void save(ManRequest manRequest) {
        Man man = mapper.toMan(manRequest);
        if (repository.findByFirstName(man.getFirstName()).isPresent()) {
            repository.save(man);
        } else {
            throw new ManNotFoundException(man.getFirstName());
        }
    }

    @Override
    public void update(ManRequest manRequest) {
        Man man = mapper.toMan(manRequest);
        if (repository.findByFirstName(man.getFirstName()).isEmpty()) {
            repository.save(man);
        } else {
            throw new ManNotFoundException(man.getFirstName());
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
    public void setWoman(UUID manId, UUID womanId) {
        // ToDo
    }

    @Override
    public void deleteWoman(UUID manId, UUID womanId) {
        // ToDo
    }
}
