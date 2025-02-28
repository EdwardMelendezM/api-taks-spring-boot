package com.hexagonal.taks.projects.application.usecases;

import com.hexagonal.taks.projects.domain.models.Project;
import com.hexagonal.taks.projects.domain.ports.in.CreateProjectUseCase;
import com.hexagonal.taks.projects.domain.ports.out.ProjectRepositoryPort;

public class CreateProjectUseCaseImpl implements CreateProjectUseCase {
    private final ProjectRepositoryPort projectRepositoryPort;

    public CreateProjectUseCaseImpl(ProjectRepositoryPort projectRepositoryPort) {
        this.projectRepositoryPort = projectRepositoryPort;
    }

    @Override
    public Project createProject(Project user) {
        return projectRepositoryPort.save(user);
    }
}
