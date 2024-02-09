package ru.itis.mapper;

import org.mapstruct.Mapper;
import ru.itis.dto.request.CatRequest;
import ru.itis.dto.request.ManRequest;
import ru.itis.dto.response.CatResponse;
import ru.itis.dto.response.ManResponse;
import ru.itis.model.jpa.Cat;
import ru.itis.model.jpa.Man;

@Mapper(componentModel = "spring")
public interface ManMapper {
    Man toMan(ManRequest manRequest);

    ManResponse toResponse(Man man);
}
