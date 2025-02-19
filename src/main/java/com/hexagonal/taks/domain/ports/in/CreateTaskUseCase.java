package com.hexagonal.taks.domain.ports.in;

import com.hexagonal.taks.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
