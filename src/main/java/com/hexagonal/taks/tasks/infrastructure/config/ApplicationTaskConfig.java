package com.hexagonal.taks.tasks.infrastructure.config;

import com.hexagonal.taks.tasks.application.services.TaskService;
import com.hexagonal.taks.tasks.application.usecases.*;
import com.hexagonal.taks.tasks.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.taks.tasks.infrastructure.repositories.JpaTaskRepositoryAdapter;
import com.hexagonal.taks.users.domain.ports.out.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationTaskConfig {

    @Bean(name = "taskServiceBean")
    public TaskService taskService(
            TaskRepositoryPort taskRepositoryPort,
            @Qualifier("usersRepositoryPort") UserRepositoryPort userRepositoryPort
    ) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort, userRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort)
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }
}