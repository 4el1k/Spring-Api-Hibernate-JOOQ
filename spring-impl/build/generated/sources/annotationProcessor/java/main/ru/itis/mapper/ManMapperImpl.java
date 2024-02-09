package ru.itis.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.dto.request.ManRequest;
import ru.itis.dto.response.ManResponse;
import ru.itis.model.jpa.Man;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-04T20:23:56+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class ManMapperImpl implements ManMapper {

    @Override
    public Man toMan(ManRequest manRequest) {
        if ( manRequest == null ) {
            return null;
        }

        Man.ManBuilder<?, ?> man = Man.builder();

        man.firstName( manRequest.firstName() );
        man.lastName( manRequest.lastName() );
        man.age( manRequest.age() );

        return man.build();
    }

    @Override
    public ManResponse toResponse(Man man) {
        if ( man == null ) {
            return null;
        }

        String firstName = null;
        String lastName = null;
        int age = 0;

        firstName = man.getFirstName();
        lastName = man.getLastName();
        age = man.getAge();

        ManResponse manResponse = new ManResponse( firstName, lastName, age );

        return manResponse;
    }
}
