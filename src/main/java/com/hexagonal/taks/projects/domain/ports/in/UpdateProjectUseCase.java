package com.hexagonal.taks.projects.domain.ports.in;

import com.hexagonal.taks.projects.domain.models.Project;

import java.util.Optional;

public interface UpdateProjectUseCase {
    Optional<Project> updateProject(Long id, Project task);
}
