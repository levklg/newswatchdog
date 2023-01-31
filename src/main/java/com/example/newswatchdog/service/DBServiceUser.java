package com.example.newswatchdog.service;

import com.example.newswatchdog.model.User;

public interface DBServiceUser {
    public void close();
    void updateUser( User user);
    User findByUserName(String name);
}