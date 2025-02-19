package com.hexagonal.users.application.usecases;

import com.hexagonal.users.domain.models.User;
import com.hexagonal.users.domain.ports.in.DeleteUserUseCase;
import com.hexagonal.users.domain.ports.out.UserRepositoryPort;

import java.util.Optional;

public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public DeleteUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> task = userRepositoryPort.findById(id);
        if (task.isEmpty()) {
            return false;
        }
        return userRepositoryPort.deleteById(id);
    }
}
