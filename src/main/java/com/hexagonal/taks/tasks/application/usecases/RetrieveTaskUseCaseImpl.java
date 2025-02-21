package com.hexagonal.taks.tasks.application.usecases;

import com.hexagonal.taks.tasks.domain.models.Task;
import com.hexagonal.taks.tasks.domain.ports.in.RetrieveTaskUseCase;
import com.hexagonal.taks.tasks.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> getTask(Long id) {
        Optional<Task> task = taskRepositoryPort.findById(id);
        if (task.isEmpty()) {
            return Optional.empty();
        }
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }
}
