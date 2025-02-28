package com.hexagonal.taks.projects.domain.ports.out;

import com.hexagonal.taks.projects.domain.models.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepositoryPort {
    Project save(Project task);
    Optional<Project> findById(Long id);
    boolean deleteById(Long id);
    Optional<Project> update(Long id, Project task);
    List<Project> findAll();
}
