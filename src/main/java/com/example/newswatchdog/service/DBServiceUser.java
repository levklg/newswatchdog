package com.example.newswatchdog.service;




import com.example.newswatchdog.model.User;

import java.util.List;
import java.util.Optional;

public interface DBServiceUser {

    User saveUser(User user);

    User getUser(long id);

    List<User> findAll();
}