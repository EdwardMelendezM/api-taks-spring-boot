package com.hexagonal.taks.tasks.infrastructure.repositories;

import com.hexagonal.taks.tasks.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
