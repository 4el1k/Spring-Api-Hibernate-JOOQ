package ru.itis.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuperBuilder
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "man")
public class Man extends AbstractHuman {
    @OneToOne(mappedBy = "husband")
    private Woman wife;
}