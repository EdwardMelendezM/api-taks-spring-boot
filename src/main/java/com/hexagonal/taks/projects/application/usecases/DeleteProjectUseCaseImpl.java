package com.hexagonal.taks.projects.application.usecases;

import com.hexagonal.taks.projects.domain.models.Project;
import com.hexagonal.taks.projects.domain.ports.in.DeleteProjectUseCase;
import com.hexagonal.taks.projects.domain.ports.out.ProjectRepositoryPort;

import java.util.Optional;

public class DeleteProjectUseCaseImpl implements DeleteProjectUseCase {

    private final ProjectRepositoryPort projectRepositoryPort;

    public DeleteProjectUseCaseImpl(ProjectRepositoryPort projectRepositoryPort) {
        this.projectRepositoryPort = projectRepositoryPort;
    }

    @Override
    public boolean deleteProject(Long id) {
        Optional<Project> task = projectRepositoryPort.findById(id);
        if (task.isEmpty()) {
            return false;
        }
        return projectRepositoryPort.deleteById(id);
    }
}
