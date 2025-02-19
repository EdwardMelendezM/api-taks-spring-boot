package com.hexagonal.users.domain.ports.in;

import com.hexagonal.users.domain.models.User;

public interface CreateTaskUseCase {
    User createTask(User task);
}
