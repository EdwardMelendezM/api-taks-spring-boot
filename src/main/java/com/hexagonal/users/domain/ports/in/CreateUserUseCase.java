package com.hexagonal.users.domain.ports.in;

import com.hexagonal.users.domain.models.User;

public interface CreateUserUseCase {
    User createUser(User task);
}
