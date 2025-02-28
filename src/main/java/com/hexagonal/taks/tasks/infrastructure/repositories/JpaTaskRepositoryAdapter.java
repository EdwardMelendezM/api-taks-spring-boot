package com.hexagonal.taks.tasks.infrastructure.repositories;

import com.hexagonal.taks.projects.infrastructure.entities.ProjectEntity;
import com.hexagonal.taks.tasks.domain.models.Task;
import com.hexagonal.taks.tasks.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.taks.tasks.infrastructure.entities.TaskEntity;
import com.hexagonal.taks.users.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {
    private final JpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public Task save(Task task) {
        UserEntity userEntity = UserEntity.fromDomainModel(task.getUser());
        ProjectEntity projectEntity = ProjectEntity.fromDomainModel(task.getProject());
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task, userEntity, projectEntity);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
        return TaskEntity.toDomainModel(savedTaskEntity);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll().stream()
                .map(TaskEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Task> update(Long id, Task task) {
        if (jpaTaskRepository.existsById(task.getId())) {
            UserEntity userEntity = UserEntity.fromDomainModel(task.getUser());
            ProjectEntity projectEntity = ProjectEntity.fromDomainModel(task.getProject());
            TaskEntity taskEntity = TaskEntity.fromDomainModel(task, userEntity, projectEntity);
            TaskEntity updatedTaskEntity = jpaTaskRepository.save(taskEntity);
            return Optional.of(TaskEntity.toDomainModel(updatedTaskEntity));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaTaskRepository.existsById(id)) {
            jpaTaskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
