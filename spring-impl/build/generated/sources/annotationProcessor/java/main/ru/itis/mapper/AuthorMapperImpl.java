package ru.itis.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.itis.dto.request.AuthorRequest;
import ru.itis.dto.response.AuthorResponse;
import ru.itis.model.Author;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-08T17:33:10+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author toAuthor(AuthorRequest authorRequest) {
        if ( authorRequest == null ) {
            return null;
        }

        Author.AuthorBuilder<?, ?> author = Author.builder();

        author.name( authorRequest.name() );
        author.age( authorRequest.age() );

        return author.build();
    }

    @Override
    public AuthorResponse toResponse(Author author) {
        if ( author == null ) {
            return null;
        }

        String name = null;
        int age = 0;

        name = author.getName();
        age = author.getAge();

        AuthorResponse authorResponse = new AuthorResponse( name, age );

        return authorResponse;
    }
}
