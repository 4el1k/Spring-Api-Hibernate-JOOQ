package ru.itis.mapper;

import org.mapstruct.Mapper;
import ru.itis.dto.request.AuthorRequest;
import ru.itis.dto.response.AuthorResponse;
import ru.itis.model.Author;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toAuthor(AuthorRequest authorRequest);

    AuthorResponse toResponse(Author author);
}
