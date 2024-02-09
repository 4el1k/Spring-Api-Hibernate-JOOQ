package ru.itis.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@SuperBuilder
@Getter
public class Author extends AbstractEntity {
    private String name;
    private int age;
    private Set<Music> musics;
    private Manager manager;
}
