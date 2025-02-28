package com.hexagonal.taks.projects.domain.models;
import com.hexagonal.taks.users.domain.models.User;
import com.hexagonal.taks.users.infrastructure.entities.UserEntity;

import java.time.LocalDateTime;

public class Project {
    private Long id;
    private String name;
    private String description;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private User owner;
    private Double budget;
    private String priority;
    private LocalDateTime createdAt;

    public Project() {
    }

    public Project(Long id, String name, String description, String status, LocalDateTime startDate, LocalDateTime endDate, User owner, Double budget, String priority, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.owner = owner;
        this.budget = budget;
        this.priority = priority;
        this.createdAt = createdAt;
    }

    public Project(Long id, String name, String description, String status, LocalDateTime startDate, LocalDateTime endDate, Double budget, String priority, LocalDateTime createdAt) {
    }

    //    Generate getOwner
    public User getOwner() {
        return owner;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
