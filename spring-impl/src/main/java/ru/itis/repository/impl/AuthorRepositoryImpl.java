package ru.itis.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.itis.model.Author;
import ru.itis.model.Listener;
import ru.itis.model.Music;
import ru.itis.model.jooq.schema.Tables;
import ru.itis.repository.AuthorRepository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {
    private final DSLContext create;


    @Override
    public Optional<Author> findById(UUID id) {
        return create.select()
                .from(Tables.AUTHOR_ENTITY)
                .leftJoin(Tables.MUSIC_ENTITY)
                .on(Tables.AUTHOR_ENTITY.ID.eq(Tables.MUSIC_ENTITY.AUTHOR_ID))
                .rightJoin(Tables.MANAGER_ENTITY)
                .on(Tables.MANAGER_ENTITY.AUTHOR_ID.eq(Tables.AUTHOR_ENTITY.ID))
                .where(Tables.AUTHOR_ENTITY.ID.eq(id))
                .fetchOptionalInto(Author.class); // ToDo
    }

    @Override
    public Set<Author> getAll() {
        List<Author> authors = create.selectFrom(Tables.AUTHOR_ENTITY)
                .fetchInto(Author.class);

        return new HashSet<>(authors);
    }

    @Override
    public void save(Author author) {
        create.insertInto(Tables.AUTHOR_ENTITY,
                        Tables.AUTHOR_ENTITY.NAME,
                        Tables.AUTHOR_ENTITY.AGE)
                .values(author.getName(), author.getAge())
                .execute();
    }

    @Override
    public void update(Author author) {
        create.update(Tables.AUTHOR_ENTITY)
                .set(Tables.AUTHOR_ENTITY.NAME, author.getName())
                .set(Tables.AUTHOR_ENTITY.AGE, author.getAge())
                .where(Tables.AUTHOR_ENTITY.ID.eq(author.getId()))
                .execute();
    }

    @Override
    public void delete(UUID id) {
        create.deleteFrom(Tables.AUTHOR_ENTITY)
                .where(Tables.AUTHOR_ENTITY.ID.eq(id))
                .execute();
    }

    @Override
    public Optional<Author> findByName(String name) {
        return create.selectFrom(Tables.AUTHOR_ENTITY)
                .where(Tables.AUTHOR_ENTITY.NAME.eq(name))
                .fetchOptionalInto(Author.class);
    }
}
