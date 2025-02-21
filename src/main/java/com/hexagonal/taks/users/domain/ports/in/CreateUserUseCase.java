package com.hexagonal.taks.users.domain.ports.in;

import com.hexagonal.taks.users.domain.models.User;

public interface CreateUserUseCase {
    User createUser(User task);
}
