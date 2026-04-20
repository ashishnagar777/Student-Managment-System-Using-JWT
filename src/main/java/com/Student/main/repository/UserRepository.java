package com.Student.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Student.main.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}