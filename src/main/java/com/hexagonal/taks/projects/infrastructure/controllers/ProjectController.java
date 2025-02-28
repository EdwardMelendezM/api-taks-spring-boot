package com.hexagonal.taks.projects.infrastructure.controllers;

import com.hexagonal.taks.projects.application.services.ProjectService;
import com.hexagonal.taks.projects.domain.models.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long projectId) {
        return projectService.getProject(projectId)
                .map(project -> new ResponseEntity<>(project, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable Long projectId, @RequestBody Project updatedProject) {
        return projectService.updateProject(projectId, updatedProject)
                .map(project -> new ResponseEntity<>(project, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable Long projectId) {
        if (projectService.deleteProject(projectId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}