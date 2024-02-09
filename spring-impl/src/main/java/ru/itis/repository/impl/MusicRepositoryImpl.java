package ru.itis.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.itis.model.Author;
import ru.itis.model.Music;
import ru.itis.model.jooq.schema.Tables;
import ru.itis.repository.MusicRepository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class MusicRepositoryImpl implements MusicRepository {
    private final DSLContext create;

    @Override
    public Optional<Music> findById(UUID id) {
        return create.select()
                .from(Tables.MUSIC_ENTITY)
                .leftJoin(Tables.AUTHOR_ENTITY)
                .on(Tables.MUSIC_ENTITY.AUTHOR_ID.eq(Tables.AUTHOR_ENTITY.ID))
                .where(Tables.MUSIC_ENTITY.ID.eq(id))
                .fetchOptionalInto(Music.class); // ToDo
    }

    @Override
    public Set<Music> getAll() {
        List<Music> musics = create.selectFrom(Tables.MUSIC_ENTITY)
                .fetchInto(Music.class);

        return new HashSet<>(musics);
    }

    @Override
    public void save(Music music) {
        create.insertInto(Tables.MUSIC_ENTITY,
                        Tables.MUSIC_ENTITY.NAME,
                        Tables.MUSIC_ENTITY.AUTHOR_ID,
                        Tables.MUSIC_ENTITY.STORAGE_NAME)
                .values(music.getName(), music.getAuthor().getId(), music.getStorageName())
                .execute();

    }

    @Override
    public void update(Music music) {
        create.update(Tables.MUSIC_ENTITY)
                .set(Tables.MUSIC_ENTITY.NAME, music.getName())
                .set(Tables.MUSIC_ENTITY.AUTHOR_ID, music.getAuthor().getId())
                .set(Tables.MUSIC_ENTITY.STORAGE_NAME, music.getStorageName())
                .where(Tables.MUSIC_ENTITY.ID.eq(music.getId()))
                .execute();
    }

    @Override
    public void delete(UUID id) {
        create.deleteFrom(Tables.MUSIC_ENTITY)
                .where(Tables.MUSIC_ENTITY.ID.eq(id))
                .execute();

    }

    @Override
    public Optional<Music> findByName(String name) {
        return create.selectFrom(Tables.MUSIC_ENTITY)
                .where(Tables.MUSIC_ENTITY.NAME.eq(name))
                .fetchOptionalInto(Music.class);

    }
}
