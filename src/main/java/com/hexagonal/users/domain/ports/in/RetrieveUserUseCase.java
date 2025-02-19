package com.hexagonal.users.domain.ports.in;

import com.hexagonal.users.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface RetrieveUserUseCase {
    Optional<User> getUser(Long id);
    List<User> getAllUsers();
}
