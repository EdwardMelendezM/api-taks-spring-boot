package com.hexagonal.taks.projects.application.services;

import com.hexagonal.taks.projects.domain.models.Project;
import com.hexagonal.taks.projects.domain.ports.in.CreateProjectUseCase;
import com.hexagonal.taks.projects.domain.ports.in.DeleteProjectUseCase;
import com.hexagonal.taks.projects.domain.ports.in.RetrieveProjectUseCase;
import com.hexagonal.taks.projects.domain.ports.in.UpdateProjectUseCase;

import java.util.List;
import java.util.Optional;

public class ProjectService implements CreateProjectUseCase, DeleteProjectUseCase, UpdateProjectUseCase, RetrieveProjectUseCase {

    private final CreateProjectUseCase createProjectUseCase;
    private final DeleteProjectUseCase deleteProjectUseCase;
    private final UpdateProjectUseCase updateProjectUseCase;
    private final RetrieveProjectUseCase retrieveProjectUseCase;

    public ProjectService(CreateProjectUseCase createProjectUseCase, DeleteProjectUseCase deleteProjectUseCase, UpdateProjectUseCase updateProjectUseCase, RetrieveProjectUseCase retrieveProjectUseCase) {
        this.createProjectUseCase = createProjectUseCase;
        this.deleteProjectUseCase = deleteProjectUseCase;
        this.updateProjectUseCase = updateProjectUseCase;
        this.retrieveProjectUseCase = retrieveProjectUseCase;
    }


    @Override
    public Project createProject(Project project) {
        return createProjectUseCase.createProject(project);
    }

    @Override
    public boolean deleteProject(Long id) {
        return deleteProjectUseCase.deleteProject(id);
    }

    @Override
    public Optional<Project> getProject(Long id) {
        return retrieveProjectUseCase.getProject(id);
    }

    @Override
    public List<Project> getAllProjects() {
        return retrieveProjectUseCase.getAllProjects();
    }

    @Override
    public Optional<Project> updateProject(Long id, Project project) {
        return updateProjectUseCase.updateProject(id, project);
    }
}
