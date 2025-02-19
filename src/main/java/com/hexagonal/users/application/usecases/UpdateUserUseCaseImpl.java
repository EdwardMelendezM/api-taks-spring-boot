package com.hexagonal.users.application.usecases;

import com.hexagonal.users.domain.models.User;
import com.hexagonal.users.domain.ports.in.UpdateUserUseCase;
import com.hexagonal.users.domain.ports.out.UserRepositoryPort;

import java.util.Optional;

public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UpdateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> updateUser(Long id, User task) {
        Optional<User> taskOptional = userRepositoryPort.findById(id);
        if (taskOptional.isEmpty()) {
            return Optional.empty();
        }
        return userRepositoryPort.update(id, task);
    }
}
