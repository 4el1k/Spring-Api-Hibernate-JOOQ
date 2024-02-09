package ru.itis.mapper;

import org.mapstruct.Mapper;
import ru.itis.dto.request.CatRequest;
import ru.itis.dto.request.GrandmotherRequest;
import ru.itis.dto.response.CatResponse;
import ru.itis.dto.response.GrandmotherResponse;
import ru.itis.model.jpa.Cat;
import ru.itis.model.jpa.Grandmother;

@Mapper(componentModel = "spring")
public interface GrandmotherMapper {
    Grandmother toGrandmother(GrandmotherRequest grandmotherRequest);

    GrandmotherResponse toResponse(Grandmother grandmother);
}
