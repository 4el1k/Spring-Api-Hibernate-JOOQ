package ru.itis.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Manager extends AbstractEntity {
    private String name;
    private int age;
    private Author author;
}
