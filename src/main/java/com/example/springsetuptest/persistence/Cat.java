package com.example.springsetuptest.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * a jpa entity to persist a cat's state.
 * @author kamar baraka.*/

@Entity
@Getter
@NoArgsConstructor
public class Cat {

    @Id
    @GeneratedValue
    private long catId;

    @Getter
    @Setter
    private String name;

    public Cat(String name) {
        this.name = name;
    }

}
