package ru.itis.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@SuperBuilder
@Getter
public class Listener extends AbstractEntity{
    private String name;
    private int age;
    private Set<Music> playlist;
}
