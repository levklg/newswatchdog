package com.example.newswatchdog.service;

import com.example.newswatchdog.model.User;
import com.example.newswatchdog.model.UserSetting;
import com.example.newswatchdog.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public void saveSetting(UserSetting userSetting) {

    }
}
