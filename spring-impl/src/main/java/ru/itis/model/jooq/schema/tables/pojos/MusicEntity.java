/*
 * This file is generated by jOOQ.
 */
package ru.itis.model.jooq.schema.tables.pojos;


import java.io.Serializable;
import java.util.UUID;

import ru.itis.model.Entity;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MusicEntity extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private String storageName;
    private UUID authorId;

    public MusicEntity() {}

    public MusicEntity(MusicEntity value) {
        this.id = value.id;
        this.name = value.name;
        this.storageName = value.storageName;
        this.authorId = value.authorId;
    }

    public MusicEntity(
        UUID id,
        String name,
        String storageName,
        UUID authorId
    ) {
        this.id = id;
        this.name = name;
        this.storageName = storageName;
        this.authorId = authorId;
    }

    /**
     * Getter for <code>public.music.id</code>.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.music.id</code>.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.music.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.music.name</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>public.music.storage_name</code>.
     */
    public String getStorageName() {
        return this.storageName;
    }

    /**
     * Setter for <code>public.music.storage_name</code>.
     */
    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    /**
     * Getter for <code>public.music.author_id</code>.
     */
    public UUID getAuthorId() {
        return this.authorId;
    }

    /**
     * Setter for <code>public.music.author_id</code>.
     */
    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final MusicEntity other = (MusicEntity) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.storageName == null) {
            if (other.storageName != null)
                return false;
        }
        else if (!this.storageName.equals(other.storageName))
            return false;
        if (this.authorId == null) {
            if (other.authorId != null)
                return false;
        }
        else if (!this.authorId.equals(other.authorId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.storageName == null) ? 0 : this.storageName.hashCode());
        result = prime * result + ((this.authorId == null) ? 0 : this.authorId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MusicEntity (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(storageName);
        sb.append(", ").append(authorId);

        sb.append(")");
        return sb.toString();
    }
}
