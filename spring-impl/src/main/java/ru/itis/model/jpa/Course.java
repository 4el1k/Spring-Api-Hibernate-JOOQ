package ru.itis.model.jpa;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.itis.model.AbstractEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "course")
public class Course extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    @ToString.Exclude
    @ManyToMany
    @Builder.Default
    private List<Student> students = new ArrayList<>();
}
