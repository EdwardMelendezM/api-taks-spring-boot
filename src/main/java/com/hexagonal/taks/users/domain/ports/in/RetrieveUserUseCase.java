package com.hexagonal.taks.users.domain.ports.in;

import com.hexagonal.taks.users.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface RetrieveUserUseCase {
    Optional<User> getUser(Long id);
    List<User> getAllUsers();
}
