package com.hexagonal.taks.users.domain.ports.out;

import com.hexagonal.taks.users.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User task);
    Optional<User> findById(Long id);
    boolean deleteById(Long id);
    Optional<User> update(Long id, User task);
    List<User> findAll();
}
