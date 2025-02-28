package com.hexagonal.taks.projects.infrastructure.repositories;

import com.hexagonal.taks.projects.infrastructure.entities.ProjectEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProjectRepository extends JpaRepository<ProjectEntity, Long> {

    @Query("SELECT u FROM ProjectEntity u")
    List<ProjectEntity> findAllWithTasks();

    @Query("SELECT u FROM ProjectEntity u WHERE u.id = :id")
    @EntityGraph(attributePaths = {"tasks"})
    ProjectEntity findByIdWithTasks(Long id);
}
