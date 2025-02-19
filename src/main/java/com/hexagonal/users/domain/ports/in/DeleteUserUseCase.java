package com.hexagonal.users.domain.ports.in;

public interface DeleteUserUseCase {
    boolean deleteUser(Long id);
}
