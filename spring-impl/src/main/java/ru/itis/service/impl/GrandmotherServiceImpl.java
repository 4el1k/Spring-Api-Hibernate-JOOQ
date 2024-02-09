package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.GrandmotherRequest;
import ru.itis.dto.response.GrandmotherResponse;
import ru.itis.exception.notfound.CatNotFoundException;
import ru.itis.exception.notfound.GrandmotherNotFoundException;
import ru.itis.exception.notsaving.GrandmotherAlreadyExistException;
import ru.itis.mapper.GrandmotherMapper;
import ru.itis.model.jpa.Cat;
import ru.itis.model.jpa.Grandmother;
import ru.itis.repository.CatRepository;
import ru.itis.repository.GrandmotherRepository;
import ru.itis.service.GrandmotherService;

import java.util.*;

@Service
@RequiredArgsConstructor
public class GrandmotherServiceImpl implements GrandmotherService {
    private final GrandmotherRepository grandmotherRepository;
    private final GrandmotherMapper mapper;
    private final CatRepository catRepository;

    @Override
    public GrandmotherResponse findById(UUID id) {
        return mapper.toResponse(
                grandmotherRepository.findById(id)
                        .orElseThrow(() -> new GrandmotherNotFoundException(id))
        );
    }

    @Override
    public Set<GrandmotherResponse> getAll() {
        Iterator<Grandmother> iterator = grandmotherRepository.findAll().iterator();
        Set<GrandmotherResponse> result = new HashSet<>();
        while (iterator.hasNext()){
            result.add(
                    mapper.toResponse(iterator.next())
            );
        }

        return result;
    }

    @Override
    public void save(GrandmotherRequest grandmotherRequest) {
        Grandmother grandmother = mapper.toGrandmother(grandmotherRequest);
        if (grandmotherRepository.findByName(grandmother.getName()).isEmpty()) {
            grandmotherRepository.save(grandmother);
        } else {
            throw new GrandmotherAlreadyExistException(grandmother.getName());
        }
    }

    @Override
    public void update(GrandmotherRequest grandmotherRequest) {
        Grandmother grandmother = mapper.toGrandmother(grandmotherRequest);
        if (grandmotherRepository.findByName(grandmother.getName()).isPresent()) {
            grandmotherRepository.save(grandmother);
        } else {
            throw new GrandmotherNotFoundException(grandmother.getName());
        }
    }

    @Override
    public void delete(UUID id) {
        if (grandmotherRepository.findById(id).isPresent()) {
            grandmotherRepository.deleteById(id);
        } else {
            throw new GrandmotherNotFoundException(id);
        }
    }

    @Override
    public void addCat(UUID grandmotherId, UUID catId) {
        Optional<Grandmother> grandmotherOptional = grandmotherRepository.getGrandmotherByIdWithCats(grandmotherId);
        Optional<Cat> catOptional = catRepository.findById(catId);
        if(grandmotherOptional.isEmpty()){
            throw new GrandmotherNotFoundException(grandmotherId);
        }
        if(catOptional.isEmpty()){
            throw new CatNotFoundException(grandmotherId);
        }
        Cat cat = catOptional.get();
        Grandmother grandmother = grandmotherOptional.get();
        grandmother.getCats().add(cat);
        cat.setOwner(grandmother);
        grandmotherRepository.save(grandmother);
    }

    @Override
    public void deleteCat(UUID grandmotherId, UUID catId) {
        Optional<Grandmother> grandmotherOptional = grandmotherRepository.getGrandmotherByIdWithCats(grandmotherId);
        Optional<Cat> catOptional = catRepository.findById(catId);
        if(grandmotherOptional.isEmpty()){
            throw new GrandmotherNotFoundException(grandmotherId);
        }
        if(catOptional.isEmpty()){
            throw new CatNotFoundException(grandmotherId);
        }
        Cat cat = catOptional.get();
        Grandmother grandmother = grandmotherOptional.get();
        grandmother.getCats().remove(cat);
        cat.setOwner(null);

        grandmotherRepository.save(grandmother);
    }
}
