package ru.itis.model.jpa;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.itis.model.AbstractEntity;

import javax.persistence.*;

@SuperBuilder
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Cat extends AbstractEntity {
    @Column(nullable = false)
    private String alias;

    @ToString.Exclude
    @ManyToOne(targetEntity = Grandmother.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Grandmother owner;
}
