package ru.itis.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.dto.request.MusicRequest;
import ru.itis.dto.response.MusicResponse;
import ru.itis.model.Music;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-08T17:33:10+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class MusicMapperImpl implements MusicMapper {

    @Override
    public Music toMusic(MusicRequest musicRequest) {
        if ( musicRequest == null ) {
            return null;
        }

        Music.MusicBuilder<?, ?> music = Music.builder();

        music.name( musicRequest.name() );
        music.storageName( musicRequest.storageName() );

        return music.build();
    }

    @Override
    public MusicResponse toResponse(Music music) {
        if ( music == null ) {
            return null;
        }

        String name = null;

        name = music.getName();

        String authorName = null;

        MusicResponse musicResponse = new MusicResponse( authorName, name );

        return musicResponse;
    }
}
