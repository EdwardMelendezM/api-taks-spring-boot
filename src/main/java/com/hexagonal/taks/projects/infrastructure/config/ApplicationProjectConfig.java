package com.hexagonal.taks.projects.infrastructure.config;

import com.hexagonal.taks.projects.application.services.ProjectService;
import com.hexagonal.taks.projects.application.usecases.CreateProjectUseCaseImpl;
import com.hexagonal.taks.projects.application.usecases.DeleteProjectUseCaseImpl;
import com.hexagonal.taks.projects.application.usecases.RetrieveProjectUseCaseImpl;
import com.hexagonal.taks.projects.application.usecases.UpdateProjectUseCaseImpl;
import com.hexagonal.taks.projects.domain.ports.out.ProjectRepositoryPort;
import com.hexagonal.taks.projects.infrastructure.repositories.JpaProjectRepositoryAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProjectConfig {

    @Bean(name = "projectServiceBean")
    public ProjectService projectService(
            @Qualifier("projectsRepositoryPort") ProjectRepositoryPort projectRepositoryPort
    ) {
        return new ProjectService(
                new CreateProjectUseCaseImpl(projectRepositoryPort),
                new DeleteProjectUseCaseImpl(projectRepositoryPort),
                new UpdateProjectUseCaseImpl(projectRepositoryPort),
                new RetrieveProjectUseCaseImpl(projectRepositoryPort)
        );
    }

    @Bean
    public ProjectRepositoryPort projectsRepositoryPort(JpaProjectRepositoryAdapter jpaProjectRepositoryAdapter) {
        return jpaProjectRepositoryAdapter;
    }
}

