package com.hexagonal.users.domain.ports.in;

import com.hexagonal.users.domain.models.User;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<User> updateTask(Long id, User task);
}
