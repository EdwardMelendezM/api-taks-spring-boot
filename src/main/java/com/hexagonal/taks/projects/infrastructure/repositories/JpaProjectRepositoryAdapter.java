package com.hexagonal.taks.projects.infrastructure.repositories;

import com.hexagonal.taks.projects.domain.models.Project;
import com.hexagonal.taks.projects.domain.ports.out.ProjectRepositoryPort;
import com.hexagonal.taks.projects.infrastructure.entities.ProjectEntity;
import com.hexagonal.taks.projects.infrastructure.repositories.JpaProjectRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaProjectRepositoryAdapter implements ProjectRepositoryPort {
    private final com.hexagonal.taks.projects.infrastructure.repositories.JpaProjectRepository jpaProjectRepository;

    public JpaProjectRepositoryAdapter(JpaProjectRepository jpaProjectRepository) {
        this.jpaProjectRepository = jpaProjectRepository;
    }

    @Override
    public Project save(Project project) {
        ProjectEntity projectEntity = ProjectEntity.fromDomainModel(project);
        ProjectEntity savedProjectEntity = jpaProjectRepository.save(projectEntity);
        return ProjectEntity.toDomainModel(savedProjectEntity);
    }

    @Override
    public Optional<Project> findById(Long id) {
        return jpaProjectRepository.findById(id).map(ProjectEntity::toDomainModel);
    }

    @Override
    public List<Project> findAll() {
        return jpaProjectRepository.findAllWithTasks().stream()
                .map(ProjectEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Project> update(Long id, Project task) {
        if (jpaProjectRepository.existsById(task.getId())) {
            ProjectEntity projectEntity = ProjectEntity.fromDomainModel(task);
            ProjectEntity updatedProjectEntity = jpaProjectRepository.save(projectEntity);
            return Optional.of(ProjectEntity.toDomainModel(updatedProjectEntity));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaProjectRepository.existsById(id)) {
            jpaProjectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
