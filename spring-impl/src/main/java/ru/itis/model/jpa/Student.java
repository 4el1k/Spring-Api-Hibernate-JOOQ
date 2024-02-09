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
@Table(name = "student")
public class Student extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "students")
    @Builder.Default
    private List<Course> courses = new ArrayList<>();
}
