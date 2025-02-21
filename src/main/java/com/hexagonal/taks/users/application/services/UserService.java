package com.hexagonal.taks.users.application.services;

import com.hexagonal.taks.users.domain.models.User;
import com.hexagonal.taks.users.domain.ports.in.CreateUserUseCase;
import com.hexagonal.taks.users.domain.ports.in.DeleteUserUseCase;
import com.hexagonal.taks.users.domain.ports.in.RetrieveUserUseCase;
import com.hexagonal.taks.users.domain.ports.in.UpdateUserUseCase;

import java.util.List;
import java.util.Optional;

public class UserService implements CreateUserUseCase, DeleteUserUseCase, UpdateUserUseCase, RetrieveUserUseCase {

    private final CreateUserUseCase createUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final RetrieveUserUseCase retrieveUserUseCase;

    public UserService(CreateUserUseCase createUserUseCase, DeleteUserUseCase deleteUserUseCase, UpdateUserUseCase updateUserUseCase, RetrieveUserUseCase retrieveUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.retrieveUserUseCase = retrieveUserUseCase;
    }


    @Override
    public User createUser(User task) {
        return createUserUseCase.createUser(task);
    }

    @Override
    public boolean deleteUser(Long id) {
        return deleteUserUseCase.deleteUser(id);
    }

    @Override
    public Optional<User> getUser(Long id) {
        return retrieveUserUseCase.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return retrieveUserUseCase.getAllUsers();
    }

    @Override
    public Optional<User> updateUser(Long id, User task) {
        return updateUserUseCase.updateUser(id, task);
    }
}
