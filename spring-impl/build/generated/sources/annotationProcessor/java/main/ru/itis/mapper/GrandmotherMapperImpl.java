package ru.itis.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.dto.request.GrandmotherRequest;
import ru.itis.dto.response.GrandmotherResponse;
import ru.itis.model.jpa.Grandmother;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T21:52:47+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class GrandmotherMapperImpl implements GrandmotherMapper {

    @Override
    public Grandmother toGrandmother(GrandmotherRequest grandmotherRequest) {
        if ( grandmotherRequest == null ) {
            return null;
        }

        Grandmother.GrandmotherBuilder<?, ?> grandmother = Grandmother.builder();

        grandmother.name( grandmotherRequest.name() );

        return grandmother.build();
    }

    @Override
    public GrandmotherResponse toResponse(Grandmother grandmother) {
        if ( grandmother == null ) {
            return null;
        }

        String name = null;

        name = grandmother.getName();

        GrandmotherResponse grandmotherResponse = new GrandmotherResponse( name );

        return grandmotherResponse;
    }
}
