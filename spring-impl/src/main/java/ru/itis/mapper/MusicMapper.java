package ru.itis.mapper;

import org.mapstruct.Mapper;
import ru.itis.dto.request.MusicRequest;
import ru.itis.dto.response.MusicResponse;
import ru.itis.model.Music;

@Mapper(componentModel = "spring")
public interface MusicMapper {
    Music toMusic(MusicRequest musicRequest);

    MusicResponse toResponse(Music music);
}
