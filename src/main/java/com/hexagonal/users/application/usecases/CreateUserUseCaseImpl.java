package com.hexagonal.users.application.usecases;

import com.hexagonal.users.domain.models.User;
import com.hexagonal.users.domain.ports.in.CreateUserUseCase;
import com.hexagonal.users.domain.ports.out.UserRepositoryPort;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public CreateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(User user) {
        return userRepositoryPort.save(user);
    }
}
