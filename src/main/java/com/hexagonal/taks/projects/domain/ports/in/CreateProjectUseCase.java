package com.hexagonal.taks.projects.domain.ports.in;

import com.hexagonal.taks.projects.domain.models.Project;

public interface CreateProjectUseCase {
    Project createProject(Project project);
}
