package com.hexagonal.taks.users.infrastructure.entities;

import com.hexagonal.taks.tasks.infrastructure.entities.TaskEntity;
import com.hexagonal.taks.users.domain.models.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String gmail;
    private LocalDateTime birthDate;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TaskEntity> tasks;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String surname, String gmail, LocalDateTime birthDate, LocalDateTime createdAt, List<TaskEntity> tasks) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gmail = gmail;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.tasks = tasks;
    }

    // Convert domain model (User) to infrastructure entity (UserEntity)
    public static UserEntity fromDomainModel(User user) {
        List<TaskEntity> taskEntities = user.getTasks().stream()
                .map(task -> TaskEntity.fromDomainModel(task, UserEntity.fromDomainModel(user)))
                .collect(Collectors.toList());

        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getGmail(),
                user.getBirthDate(),
                user.getCreatedAt(),
                taskEntities
        );
    }

    // Convert infrastructure entity (UserEntity) to domain model (User)
    public static User toDomainModel(UserEntity userEntity) {
        User user = new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getSurname(),
                userEntity.getGmail(),
                userEntity.getBirthDate(),
                userEntity.getCreatedAt()
        );

        // Convert and add tasks to domain model
        userEntity.getTasks().forEach(taskEntity -> user.addTask(TaskEntity.toDomainModel(taskEntity)));

        return user;
    }

    // Getters and Setters

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
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

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
