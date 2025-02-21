package com.hexagonal.taks.tasks.application.usecases;

import com.hexagonal.taks.tasks.domain.models.Task;
import com.hexagonal.taks.tasks.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.taks.tasks.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.taks.users.domain.models.User;
import com.hexagonal.taks.users.domain.ports.out.UserRepositoryPort;

import java.util.Optional;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort, UserRepositoryPort userRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Task createTask(Task task, Long userId) {
        Optional<User> user =  userRepositoryPort.findById(userId);
        return taskRepositoryPort.save(task);
    }
}
