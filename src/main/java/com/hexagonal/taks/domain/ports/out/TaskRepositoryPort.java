package com.hexagonal.taks.domain.ports.out;

import com.hexagonal.taks.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Task save(Task task);
    Optional<Task> findById(Long id);
    boolean deleteById(Long id);
    Optional<Task> update(Long id, Task task);
    List<Task> findAll();
}
