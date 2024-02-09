package ru.itis.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.springframework.stereotype.Repository;
import ru.itis.model.Author;
import ru.itis.model.Manager;
import ru.itis.model.jooq.schema.Tables;
import ru.itis.repository.ManagerRepository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class ManagerRepositoryImpl implements ManagerRepository {
    private final DSLContext create;

    @Override
    public Optional<Manager> findById(UUID id) {
        return create.select()
                .from(Tables.MANAGER_ENTITY)
                .rightJoin(Tables.MANAGER_ENTITY)
                .on(Tables.MANAGER_ENTITY.ID.eq(id))
                .fetchOptionalInto(Manager.class); // ToDo
    }

    @Override
    public Set<Manager> getAll() {
        List<Manager> managers = create.selectFrom(Tables.MANAGER_ENTITY)
                .fetchInto(Manager.class);

        return new HashSet<>(managers);
    }

    @Override
    public void save(Manager manager) {
        create.insertInto(Tables.MANAGER_ENTITY,
                        Tables.MANAGER_ENTITY.NAME,
                        Tables.MANAGER_ENTITY.AGE)
                .values(manager.getName(), manager.getAge())
                .execute();
    }

    @Override
    public void update(Manager manager) {
        create.update(Tables.MANAGER_ENTITY)
                .set(Tables.MANAGER_ENTITY.NAME, manager.getName())
                .set(Tables.MANAGER_ENTITY.AGE, manager.getAge())
                .where(Tables.MANAGER_ENTITY.ID.eq(manager.getId()))
                .execute();
    }

    @Override
    public void delete(UUID id) {
        create.deleteFrom(Tables.MANAGER_ENTITY)
                .where(Tables.MANAGER_ENTITY.ID.eq(id))
                .execute();
    }

    @Override
    public Optional<Manager> findByName(String name) {
        return create.selectFrom(Tables.MANAGER_ENTITY)
                .where(Tables.MANAGER_ENTITY.NAME.eq(name))
                .fetchOptionalInto(Manager.class);
    }

    @Override
    public void setAuthor(UUID managerId, UUID authorId) {
        create.update(Tables.MANAGER_ENTITY)
                .set(Tables.MANAGER_ENTITY.AUTHOR_ID, authorId)
                .where(Tables.MANAGER_ENTITY.ID.eq(managerId))
                .execute();
    }

    @Override
    public void deleteAuthor(UUID managerId, UUID authorId) {
        create.update(Tables.MANAGER_ENTITY)
                .set(Tables.MANAGER_ENTITY.AUTHOR_ID, (Field<UUID>) null)
                .where(Tables.MANAGER_ENTITY.ID.eq(managerId))
                .execute();
    }
}
