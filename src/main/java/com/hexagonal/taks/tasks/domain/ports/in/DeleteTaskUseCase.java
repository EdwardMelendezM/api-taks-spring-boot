package com.hexagonal.taks.tasks.domain.ports.in;

public interface DeleteTaskUseCase {
    boolean deleteTask(Long id);
}
