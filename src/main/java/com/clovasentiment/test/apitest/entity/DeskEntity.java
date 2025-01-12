package com.clovasentiment.test.apitest.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "DESK")
public class DeskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String memberName;

    public DeskEntity(Long id, String memberName) {
        this.id = id;
        this.memberName = memberName;
    }

    public DeskEntity( String memberName) {
        this.memberName = memberName;
    }
}
