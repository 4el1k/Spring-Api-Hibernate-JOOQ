package ru.itis.mapper;

import org.mapstruct.Mapper;
import ru.itis.dto.request.AuthorRequest;
import ru.itis.dto.request.ManagerRequest;
import ru.itis.dto.response.AuthorResponse;
import ru.itis.dto.response.ManagerResponse;
import ru.itis.model.Author;
import ru.itis.model.Manager;

@Mapper(componentModel = "spring") // !
public interface ManagerMapper {
    Manager toManager(ManagerRequest managerRequest);

    ManagerResponse toResponse(Manager manager);
}
