package com.hexagonal.users.domain.models;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String name;
    private String surname;
    private String gmail;
    private LocalDateTime birthDate;
    private LocalDateTime createdAt;

    public User(
        Long id,
        String name,
        String surname,
        String gmail,
        LocalDateTime birthDate,
        LocalDateTime createdAt
    ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gmail = gmail;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
    }

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

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
