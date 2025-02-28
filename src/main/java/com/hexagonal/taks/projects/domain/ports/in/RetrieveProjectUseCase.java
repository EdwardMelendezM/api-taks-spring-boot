package com.hexagonal.taks.projects.domain.ports.in;

import com.hexagonal.taks.projects.domain.models.Project;

import java.util.List;
import java.util.Optional;

public interface RetrieveProjectUseCase {
    Optional<Project> getProject(Long id);
    List<Project> getAllProjects();
}
