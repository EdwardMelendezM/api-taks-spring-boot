package com.hexagonal.users.domain.ports.in;

public interface DeleteTaskUseCase {
    boolean deleteTask(Long id);
}
