package com.hexagonal.taks.projects.application.usecases;

import com.hexagonal.taks.projects.domain.models.Project;
import com.hexagonal.taks.projects.domain.ports.in.RetrieveProjectUseCase;
import com.hexagonal.taks.projects.domain.ports.out.ProjectRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveProjectUseCaseImpl implements RetrieveProjectUseCase {

    private final ProjectRepositoryPort projectRepositoryPort;

    public RetrieveProjectUseCaseImpl(ProjectRepositoryPort projectRepositoryPort) {
        this.projectRepositoryPort = projectRepositoryPort;
    }

    @Override
    public Optional<Project> getProject(Long id) {
        Optional<Project> task = projectRepositoryPort.findById(id);
        if (task.isEmpty()) {
            return Optional.empty();
        }
        return projectRepositoryPort.findById(id);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepositoryPort.findAll();
    }
}
