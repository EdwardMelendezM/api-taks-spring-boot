package com.hexagonal.users.application.usecases;

import com.hexagonal.taks.domain.models.Task;
import com.hexagonal.taks.domain.ports.in.UpdateTaskUseCase;
import com.hexagonal.taks.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        Optional<Task> taskOptional = taskRepositoryPort.findById(id);
        if (taskOptional.isEmpty()) {
            return Optional.empty();
        }
        return taskRepositoryPort.update(id, task);
    }
}
