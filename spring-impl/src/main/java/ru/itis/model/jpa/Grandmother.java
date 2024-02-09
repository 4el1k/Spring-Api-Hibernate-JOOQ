package ru.itis.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@Entity
@Table(name = "grandmother")
public class Grandmother extends AbstractEntity {
    @Column(nullable = false)
    private String name;

    @OneToMany(targetEntity = Cat.class, fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Cat> cats = new ArrayList<>();
}
