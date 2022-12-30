package com.example.newswatchdog.repository;

import com.example.newswatchdog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

   // List<User> findByUserName(String username);

    User findById(long id);
}
