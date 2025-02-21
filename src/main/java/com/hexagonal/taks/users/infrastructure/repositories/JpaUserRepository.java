package com.hexagonal.taks.users.infrastructure.repositories;

import com.hexagonal.taks.users.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u")
    @EntityGraph(attributePaths = {"tasks"})
    List<UserEntity> findAllWithTasks();

    @Query("SELECT u FROM UserEntity u WHERE u.id = :id")
    @EntityGraph(attributePaths = {"tasks"})
    UserEntity findByIdWithTasks(Long id);
}
