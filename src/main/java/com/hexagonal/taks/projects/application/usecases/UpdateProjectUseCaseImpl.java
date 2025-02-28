package com.hexagonal.taks.projects.application.usecases;

import com.hexagonal.taks.projects.domain.models.Project;
import com.hexagonal.taks.projects.domain.ports.in.UpdateProjectUseCase;
import com.hexagonal.taks.projects.domain.ports.out.ProjectRepositoryPort;

import java.util.Optional;

public class UpdateProjectUseCaseImpl implements UpdateProjectUseCase {

    private final ProjectRepositoryPort projectRepositoryPort;

    public UpdateProjectUseCaseImpl(ProjectRepositoryPort projectRepositoryPort) {
        this.projectRepositoryPort = projectRepositoryPort;
    }

    @Override
    public Optional<Project> updateProject(Long id, Project task) {
        Optional<Project> taskOptional = projectRepositoryPort.findById(id);
        if (taskOptional.isEmpty()) {
            return Optional.empty();
        }
        return projectRepositoryPort.update(id, task);
    }
}
