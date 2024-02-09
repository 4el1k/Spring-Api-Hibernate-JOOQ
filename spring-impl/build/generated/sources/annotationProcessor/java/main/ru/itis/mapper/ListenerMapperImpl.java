package ru.itis.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.dto.request.ListenerRequest;
import ru.itis.dto.response.ListenerResponse;
import ru.itis.model.Listener;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-08T17:33:10+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class ListenerMapperImpl implements ListenerMapper {

    @Override
    public Listener toListener(ListenerRequest listenerRequest) {
        if ( listenerRequest == null ) {
            return null;
        }

        Listener.ListenerBuilder<?, ?> listener = Listener.builder();

        listener.name( listenerRequest.name() );
        listener.age( listenerRequest.age() );

        return listener.build();
    }

    @Override
    public ListenerResponse toResponse(Listener listener) {
        if ( listener == null ) {
            return null;
        }

        String name = null;
        int age = 0;

        name = listener.getName();
        age = listener.getAge();

        ListenerResponse listenerResponse = new ListenerResponse( name, age );

        return listenerResponse;
    }
}
