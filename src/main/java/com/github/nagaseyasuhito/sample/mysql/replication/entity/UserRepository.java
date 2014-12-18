package com.github.nagaseyasuhito.sample.mysql.replication.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional(readOnly = true)
    Optional<User> findByName(String name);
}
