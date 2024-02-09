package ru.itis.mapper;

import org.mapstruct.Mapper;
import ru.itis.dto.request.CatRequest;
import ru.itis.dto.response.CatResponse;
import ru.itis.model.jpa.Cat;

@Mapper(componentModel = "spring")
public interface CatMapper {
    Cat toCat(CatRequest catRequest);

    CatResponse toResponse(Cat cat);
}
