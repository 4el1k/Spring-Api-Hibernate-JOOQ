package ru.itis.mapper;

import org.mapstruct.Mapper;
import ru.itis.dto.request.ListenerRequest;
import ru.itis.dto.response.ListenerResponse;
import ru.itis.model.Listener;

@Mapper(componentModel = "spring") // !
public interface ListenerMapper {
    Listener toListener(ListenerRequest listenerRequest);

    ListenerResponse toResponse(Listener listener);
}
