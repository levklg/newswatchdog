package com.example.newswatchdog.service;




import com.example.newswatchdog.model.User;

import java.util.List;
import java.util.Optional;

public interface DBServiceUser {
    public void close();

    void updateUser( User user);

    User findByUserName(String name);
}