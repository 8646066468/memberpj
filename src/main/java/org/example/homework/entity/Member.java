package org.example.homework.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //id는 데이터베이스에서 자동으로 올려줌
    public Member(String name) {
        this.name = name;
    }

    public void updateName(String name) {
        this.name = name;
    }

}
