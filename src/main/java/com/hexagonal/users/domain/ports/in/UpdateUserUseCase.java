package com.hexagonal.users.domain.ports.in;

import com.hexagonal.users.domain.models.User;

import java.util.Optional;

public interface UpdateUserUseCase {
    Optional<User> updateUser(Long id, User task);
}
