package com.hexagonal.taks.users.application.usecases;

import com.hexagonal.taks.users.domain.models.User;
import com.hexagonal.taks.users.domain.ports.in.CreateUserUseCase;
import com.hexagonal.taks.users.domain.ports.out.UserRepositoryPort;

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
