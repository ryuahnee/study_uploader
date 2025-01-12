package com.clovasentiment.test.dsl.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {

    @Id
    private Long id;

    private String name;

    private int age;

    public UserEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
