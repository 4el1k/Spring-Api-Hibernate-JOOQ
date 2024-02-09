package ru.itis.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.itis.dto.request.ListenerRequest;
import ru.itis.model.Listener;
import ru.itis.model.jooq.schema.Tables;
import ru.itis.repository.ListenerRepository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class ListenerRepositoryImpl implements ListenerRepository {
    private final DSLContext create;

    @Override
    public Optional<Listener> findById(UUID id) {
        return create.selectFrom(Tables.LISTENER_ENTITY)
                .where(Tables.LISTENER_ENTITY.ID.eq(id))
                .fetchOptionalInto(Listener.class); // ToDo
    }

    @Override
    public Set<Listener> getAll() {
        List<Listener> listeners = create.selectFrom(Tables.LISTENER_ENTITY)
                .fetchInto(Listener.class);

        return new HashSet<>(listeners);

    }

    @Override
    public void save(Listener listener) {
        create.insertInto(Tables.LISTENER_ENTITY,
                        Tables.LISTENER_ENTITY.NAME,
                        Tables.ACCOUNT_ENTITY.AGE)
                .values(listener.getName(), listener.getAge())
                .execute();
    }

    @Override
    public void update(Listener listener) {
        create.update(Tables.LISTENER_ENTITY)
                .set(Tables.LISTENER_ENTITY.NAME, listener.getName())
                .set(Tables.LISTENER_ENTITY.AGE, listener.getAge())
                .where(Tables.LISTENER_ENTITY.ID.eq(listener.getId()))
                .execute();
    }

    @Override
    public void delete(UUID id) {
        create.deleteFrom(Tables.LISTENER_ENTITY)
                .where(Tables.LISTENER_ENTITY.ID.eq(id))
                .execute();
    }

    @Override
    public void updatePlaylist(UUID listenerId, UUID musicId) {
        create.insertInto(Tables.ASSOCIATIVE_LISTENER_MUSIC_ENTITY,
                        Tables.ASSOCIATIVE_LISTENER_MUSIC_ENTITY.MUSIC_ID,
                        Tables.ASSOCIATIVE_LISTENER_MUSIC_ENTITY.LISTENER_ID)
                .values(musicId, listenerId)
                .execute();
    }

    @Override
    public void deleteMusicFromPlaylist(UUID listenerId, UUID musicId) {
        create.deleteFrom(Tables.ASSOCIATIVE_LISTENER_MUSIC_ENTITY)
                .where(
                        Tables.ASSOCIATIVE_LISTENER_MUSIC_ENTITY.MUSIC_ID.eq(musicId)
                        .and(
                                Tables.ASSOCIATIVE_LISTENER_MUSIC_ENTITY.LISTENER_ID.eq(listenerId)
                        )
                )
                .execute();
    }

    @Override
    public Optional<Listener> findByName(String name) {
        return create.selectFrom(Tables.LISTENER_ENTITY)
                .where(Tables.LISTENER_ENTITY.NAME.eq(name))
                .fetchOptionalInto(Listener.class);
    }
}
