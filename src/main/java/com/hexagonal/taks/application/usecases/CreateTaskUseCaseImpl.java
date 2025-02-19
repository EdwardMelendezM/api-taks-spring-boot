package com.hexagonal.taks.application.usecases;

import com.hexagonal.taks.domain.models.Task;
import com.hexagonal.taks.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.taks.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
