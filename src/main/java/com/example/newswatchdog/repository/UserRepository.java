package com.example.newswatchdog.repository;

import com.example.newswatchdog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // List<User> findByUserName(String username);

    User findById(long id);
}
