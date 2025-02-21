package com.hexagonal.taks.tasks.domain.ports.in;

import com.hexagonal.taks.tasks.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task, Long userId);
}
