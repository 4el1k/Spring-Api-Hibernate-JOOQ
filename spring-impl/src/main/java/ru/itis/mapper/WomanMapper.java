package ru.itis.mapper;

import org.mapstruct.Mapper;
import ru.itis.dto.request.ManRequest;
import ru.itis.dto.request.WomanRequest;
import ru.itis.dto.response.WomanResponse;
import ru.itis.model.jpa.Man;
import ru.itis.model.jpa.Woman;

@Mapper(componentModel = "spring")
public interface WomanMapper {
    Woman toWoman(WomanRequest womanRequest);

    WomanResponse toResponse(Woman woman);
}
