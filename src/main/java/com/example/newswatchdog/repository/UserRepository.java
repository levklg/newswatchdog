package com.example.newswatchdog.repository;



import com.example.newswatchdog.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    void save(User user);

    User findById(long id);

    User findByName(String nickname);
    User getUser();
}
