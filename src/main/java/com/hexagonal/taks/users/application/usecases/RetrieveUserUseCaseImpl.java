package com.hexagonal.taks.users.application.usecases;

import com.hexagonal.taks.users.domain.models.User;
import com.hexagonal.taks.users.domain.ports.in.RetrieveUserUseCase;
import com.hexagonal.taks.users.domain.ports.out.UserRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveUserUseCaseImpl implements RetrieveUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public RetrieveUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> getUser(Long id) {
        Optional<User> task = userRepositoryPort.findById(id);
        if (task.isEmpty()) {
            return Optional.empty();
        }
        return userRepositoryPort.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoryPort.findAll();
    }
}
