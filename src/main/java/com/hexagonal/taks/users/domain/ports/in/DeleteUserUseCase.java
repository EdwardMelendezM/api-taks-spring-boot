package com.hexagonal.taks.users.domain.ports.in;

public interface DeleteUserUseCase {
    boolean deleteUser(Long id);
}
