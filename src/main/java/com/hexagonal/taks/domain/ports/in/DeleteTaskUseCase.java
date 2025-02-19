package com.hexagonal.taks.domain.ports.in;

public interface DeleteTaskUseCase {
    boolean deleteTask(Long id);
}
