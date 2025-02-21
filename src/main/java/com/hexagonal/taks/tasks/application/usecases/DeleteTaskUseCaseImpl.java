package com.hexagonal.taks.tasks.application.usecases;

import com.hexagonal.taks.tasks.domain.models.Task;
import com.hexagonal.taks.tasks.domain.ports.in.DeleteTaskUseCase;
import com.hexagonal.taks.tasks.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public DeleteTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public boolean deleteTask(Long id) {
        Optional<Task> task = taskRepositoryPort.findById(id);
        if (task.isEmpty()) {
            return false;
        }
        return taskRepositoryPort.deleteById(id);
    }
}
