package ru.itis.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.dto.request.WomanRequest;
import ru.itis.dto.response.WomanResponse;
import ru.itis.model.jpa.Woman;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-04T20:23:56+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class WomanMapperImpl implements WomanMapper {

    @Override
    public Woman toWoman(WomanRequest womanRequest) {
        if ( womanRequest == null ) {
            return null;
        }

        Woman.WomanBuilder<?, ?> woman = Woman.builder();

        woman.firstName( womanRequest.firstName() );
        woman.lastName( womanRequest.lastName() );
        woman.age( womanRequest.age() );

        return woman.build();
    }

    @Override
    public WomanResponse toResponse(Woman woman) {
        if ( woman == null ) {
            return null;
        }

        String firstName = null;
        String lastName = null;
        int age = 0;

        firstName = woman.getFirstName();
        lastName = woman.getLastName();
        age = woman.getAge();

        WomanResponse womanResponse = new WomanResponse( firstName, lastName, age );

        return womanResponse;
    }
}
