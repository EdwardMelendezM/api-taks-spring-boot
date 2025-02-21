package com.hexagonal.taks.tasks.application.services;

import com.hexagonal.taks.tasks.domain.models.Task;
import com.hexagonal.taks.tasks.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class TaskService implements CreateTaskUseCase, DeleteTaskUseCase, UpdateTaskUseCase, RetrieveTaskUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;

    public TaskService(CreateTaskUseCase createTaskUseCase, DeleteTaskUseCase deleteTaskUseCase, UpdateTaskUseCase updateTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
    }


    @Override
    public Task createTask(Task task, Long userId) {
        return createTaskUseCase.createTask(task, userId);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return retrieveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return updateTaskUseCase.updateTask(id, task);
    }
}
