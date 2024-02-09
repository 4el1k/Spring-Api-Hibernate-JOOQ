package ru.itis.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.dto.request.CatRequest;
import ru.itis.dto.response.CatResponse;
import ru.itis.model.jpa.Cat;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-07T21:52:47+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class CatMapperImpl implements CatMapper {

    @Override
    public Cat toCat(CatRequest catRequest) {
        if ( catRequest == null ) {
            return null;
        }

        Cat.CatBuilder<?, ?> cat = Cat.builder();

        cat.alias( catRequest.alias() );

        return cat.build();
    }

    @Override
    public CatResponse toResponse(Cat cat) {
        if ( cat == null ) {
            return null;
        }

        String alias = null;

        alias = cat.getAlias();

        CatResponse catResponse = new CatResponse( alias );

        return catResponse;
    }
}
