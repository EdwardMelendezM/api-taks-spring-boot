package com.hexagonal.taks.users.infrastructure.config;

import com.hexagonal.taks.users.application.services.UserService;
import com.hexagonal.taks.users.application.usecases.CreateUserUseCaseImpl;
import com.hexagonal.taks.users.application.usecases.DeleteUserUseCaseImpl;
import com.hexagonal.taks.users.application.usecases.RetrieveUserUseCaseImpl;
import com.hexagonal.taks.users.application.usecases.UpdateUserUseCaseImpl;
import com.hexagonal.taks.users.domain.ports.out.UserRepositoryPort;
import com.hexagonal.taks.users.infrastructure.repositories.JpaUserRepositoryAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationUserConfig {

    @Bean(name = "userServiceBean")
    public UserService userService(
            @Qualifier("usersRepositoryPort") UserRepositoryPort userRepositoryPort
    ) {
        return new UserService(
                new CreateUserUseCaseImpl(userRepositoryPort),
                new DeleteUserUseCaseImpl(userRepositoryPort),
                new UpdateUserUseCaseImpl(userRepositoryPort),
                new RetrieveUserUseCaseImpl(userRepositoryPort)
        );
    }

    @Bean
    public UserRepositoryPort usersRepositoryPort(JpaUserRepositoryAdapter jpaUserRepositoryAdapter) {
        return jpaUserRepositoryAdapter;
    }
}

