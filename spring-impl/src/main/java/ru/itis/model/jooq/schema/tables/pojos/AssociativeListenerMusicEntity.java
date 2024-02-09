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
public class AssociativeListenerMusicEntity extends Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID musicId;
    private UUID listenerId;

    public AssociativeListenerMusicEntity() {}

    public AssociativeListenerMusicEntity(AssociativeListenerMusicEntity value) {
        this.musicId = value.musicId;
        this.listenerId = value.listenerId;
    }

    public AssociativeListenerMusicEntity(
        UUID musicId,
        UUID listenerId
    ) {
        this.musicId = musicId;
        this.listenerId = listenerId;
    }

    /**
     * Getter for <code>public.associative_listener_music.music_id</code>.
     */
    public UUID getMusicId() {
        return this.musicId;
    }

    /**
     * Setter for <code>public.associative_listener_music.music_id</code>.
     */
    public void setMusicId(UUID musicId) {
        this.musicId = musicId;
    }

    /**
     * Getter for <code>public.associative_listener_music.listener_id</code>.
     */
    public UUID getListenerId() {
        return this.listenerId;
    }

    /**
     * Setter for <code>public.associative_listener_music.listener_id</code>.
     */
    public void setListenerId(UUID listenerId) {
        this.listenerId = listenerId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final AssociativeListenerMusicEntity other = (AssociativeListenerMusicEntity) obj;
        if (this.musicId == null) {
            if (other.musicId != null)
                return false;
        }
        else if (!this.musicId.equals(other.musicId))
            return false;
        if (this.listenerId == null) {
            if (other.listenerId != null)
                return false;
        }
        else if (!this.listenerId.equals(other.listenerId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.musicId == null) ? 0 : this.musicId.hashCode());
        result = prime * result + ((this.listenerId == null) ? 0 : this.listenerId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AssociativeListenerMusicEntity (");

        sb.append(musicId);
        sb.append(", ").append(listenerId);

        sb.append(")");
        return sb.toString();
    }
}