package ru.itis.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@SuperBuilder
@Getter
public class Music extends AbstractEntity {
    private String name;
    private String storageName;
    private Author author;
    private Set<Listener> listeners = new HashSet<>();
}
