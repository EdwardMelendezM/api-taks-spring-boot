package com.hexagonal.taks.tasks.domain.models;

import com.hexagonal.taks.users.domain.models.User;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private boolean completed;
    private User user; // Many-to-One relationship

    public Task(
        Long id,
        String title,
        String description,
        LocalDateTime createdAt,
        boolean completed,
        User user
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.completed = completed;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
