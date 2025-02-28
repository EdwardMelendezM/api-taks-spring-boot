package com.hexagonal.taks.projects.infrastructure.entities;

import com.hexagonal.taks.projects.domain.models.Project;
import com.hexagonal.taks.tasks.infrastructure.entities.TaskEntity;
import com.hexagonal.taks.users.domain.models.User;
import com.hexagonal.taks.users.infrastructure.entities.UserEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double budget;
    private String priority;
    private LocalDateTime createdAt;


    @OneToOne
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;

    public ProjectEntity() {
    }

    public ProjectEntity(
            String name, String description, String status, LocalDateTime startDate, LocalDateTime endDate, Double budget, String priority, LocalDateTime createdAt, Long owner_id) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.priority = priority;
        this.createdAt = createdAt;
    }

    //    Generate fromDomainModel
    public static ProjectEntity fromDomainModel(Project project) {
        return new ProjectEntity(
                project.getName(),
                project.getDescription(),
                project.getStatus(),
                project.getStartDate(),
                project.getEndDate(),
                project.getBudget(),
                project.getPriority(),
                project.getCreatedAt(),
                project.getOwner().getId()
        );
    }

//    toDomainModel
    public static Project toDomainModel(ProjectEntity projectEntity) {
        return new Project(
                projectEntity.getId(),
                projectEntity.getName(),
                projectEntity.getDescription(),
                projectEntity.getStatus(),
                projectEntity.getStartDate(),
                projectEntity.getEndDate(),
                projectEntity.getBudget(),
                projectEntity.getPriority(),
                projectEntity.getCreatedAt()
        );
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

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
