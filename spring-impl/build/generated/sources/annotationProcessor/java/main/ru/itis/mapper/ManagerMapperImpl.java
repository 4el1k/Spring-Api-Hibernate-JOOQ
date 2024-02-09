package ru.itis.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.dto.request.ManagerRequest;
import ru.itis.dto.response.ManagerResponse;
import ru.itis.model.Manager;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-08T17:33:10+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class ManagerMapperImpl implements ManagerMapper {

    @Override
    public Manager toManager(ManagerRequest managerRequest) {
        if ( managerRequest == null ) {
            return null;
        }

        Manager.ManagerBuilder<?, ?> manager = Manager.builder();

        manager.age( managerRequest.age() );

        return manager.build();
    }

    @Override
    public ManagerResponse toResponse(Manager manager) {
        if ( manager == null ) {
            return null;
        }

        int age = 0;

        age = manager.getAge();

        String selfName = null;
        String authorName = null;

        ManagerResponse managerResponse = new ManagerResponse( selfName, authorName, age );

        return managerResponse;
    }
}
