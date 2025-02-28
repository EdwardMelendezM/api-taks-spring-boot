package com.hexagonal.taks.tasks.infrastructure.entities;

import com.hexagonal.taks.projects.infrastructure.entities.ProjectEntity;
import com.hexagonal.taks.tasks.domain.models.Task;
import com.hexagonal.taks.users.infrastructure.entities.UserEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    public TaskEntity() {
    }

    public TaskEntity(
            String title,
            String description,
            LocalDateTime createdAt,
            boolean completed,
            UserEntity user,
            ProjectEntity project
    ) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.completed = completed;
        this.user = user;
        this.project = project;
    }

    public static TaskEntity fromDomainModel(Task task, UserEntity user, ProjectEntity project) {
        return new TaskEntity(task.getTitle(), task.getDescription(), task.getCreatedAt(), task.isCompleted(), user, project);
    }

    public static Task toDomainModel(TaskEntity taskEntity) {
        return new Task(
                taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getCreatedAt(),
                taskEntity.isCompleted(),
                Task.toDomainModel(taskEntity.getUser())
        );
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

    public void setTitle(String title) {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

}
