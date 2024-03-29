/*
 * This file is generated by jOOQ.
 */
package ru.itis.model.jooq.schema.tables.records;


import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import ru.itis.model.jooq.schema.tables.Music;
import ru.itis.model.jooq.schema.tables.pojos.MusicEntity;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MusicRecord extends UpdatableRecordImpl<MusicRecord> implements Record4<UUID, String, String, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.music.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.music.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.music.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.music.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.music.storage_name</code>.
     */
    public void setStorageName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.music.storage_name</code>.
     */
    public String getStorageName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.music.author_id</code>.
     */
    public void setAuthorId(UUID value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.music.author_id</code>.
     */
    public UUID getAuthorId() {
        return (UUID) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<UUID, String, String, UUID> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<UUID, String, String, UUID> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Music.MUSIC_ENTITY.ID;
    }

    @Override
    public Field<String> field2() {
        return Music.MUSIC_ENTITY.NAME;
    }

    @Override
    public Field<String> field3() {
        return Music.MUSIC_ENTITY.STORAGE_NAME;
    }

    @Override
    public Field<UUID> field4() {
        return Music.MUSIC_ENTITY.AUTHOR_ID;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getStorageName();
    }

    @Override
    public UUID component4() {
        return getAuthorId();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getStorageName();
    }

    @Override
    public UUID value4() {
        return getAuthorId();
    }

    @Override
    public MusicRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public MusicRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public MusicRecord value3(String value) {
        setStorageName(value);
        return this;
    }

    @Override
    public MusicRecord value4(UUID value) {
        setAuthorId(value);
        return this;
    }

    @Override
    public MusicRecord values(UUID value1, String value2, String value3, UUID value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MusicRecord
     */
    public MusicRecord() {
        super(Music.MUSIC_ENTITY);
    }

    /**
     * Create a detached, initialised MusicRecord
     */
    public MusicRecord(UUID id, String name, String storageName, UUID authorId) {
        super(Music.MUSIC_ENTITY);

        setId(id);
        setName(name);
        setStorageName(storageName);
        setAuthorId(authorId);
    }

    /**
     * Create a detached, initialised MusicRecord
     */
    public MusicRecord(MusicEntity value) {
        super(Music.MUSIC_ENTITY);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setStorageName(value.getStorageName());
            setAuthorId(value.getAuthorId());
        }
    }
}
