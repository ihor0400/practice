package com.ihor.practice.Lesson;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Lesson {

    @Id
    private Long id;

    private String name;

    // Геттери і сеттери
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
