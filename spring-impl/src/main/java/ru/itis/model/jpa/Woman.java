package ru.itis.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "woman")
public class Woman extends AbstractHuman {
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "husband_id", referencedColumnName = "id")
    private Man husband;
}
