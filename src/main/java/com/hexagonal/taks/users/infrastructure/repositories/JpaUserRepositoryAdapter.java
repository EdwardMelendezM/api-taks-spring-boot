package com.hexagonal.taks.users.infrastructure.repositories;

import com.hexagonal.taks.users.domain.models.User;
import com.hexagonal.taks.users.domain.ports.out.UserRepositoryPort;
import com.hexagonal.taks.users.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {
    private final JpaUserRepository jpaUserRepository;

    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User save(User user) {
        UserEntity taskEntity = UserEntity.fromDomainModel(user);
        UserEntity savedUserEntity = jpaUserRepository.save(taskEntity);
        return UserEntity.toDomainModel(savedUserEntity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaUserRepository.findById(id).map(UserEntity::toDomainModel);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAllWithTasks().stream()
                .map(UserEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> update(Long id, User task) {
        if (jpaUserRepository.existsById(task.getId())) {
            UserEntity taskEntity = UserEntity.fromDomainModel(task);
            UserEntity updatedUserEntity = jpaUserRepository.save(taskEntity);
            return Optional.of(UserEntity.toDomainModel(updatedUserEntity));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaUserRepository.existsById(id)) {
            jpaUserRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
