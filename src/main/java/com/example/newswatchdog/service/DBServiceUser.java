package com.example.newswatchdog.service;



import com.example.newswatchdog.model.User;


import java.util.List;

public interface DBServiceUser {

    User saveUser(User user);

    User getUser(long id);

    List<User> findAll();
}
