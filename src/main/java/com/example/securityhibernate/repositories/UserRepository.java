package com.example.securityhibernate.repositories;

import com.example.securityhibernate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findAllByUsername(String username);
}
