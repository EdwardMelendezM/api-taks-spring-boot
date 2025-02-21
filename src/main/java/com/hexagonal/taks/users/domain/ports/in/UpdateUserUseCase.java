package com.hexagonal.taks.users.domain.ports.in;

import com.hexagonal.taks.users.domain.models.User;

import java.util.Optional;

public interface UpdateUserUseCase {
    Optional<User> updateUser(Long id, User task);
}
