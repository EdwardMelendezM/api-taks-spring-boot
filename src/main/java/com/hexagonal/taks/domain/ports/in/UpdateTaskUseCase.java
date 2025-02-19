package com.hexagonal.taks.domain.ports.in;

import com.hexagonal.taks.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task task);
}
