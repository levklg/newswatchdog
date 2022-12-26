package com.example.newswatchdog.service;

import com.example.newswatchdog.model.User;
import com.example.newswatchdog.model.UserSetting;

public interface UserService {
    User getUser();
    void saveSetting(UserSetting userSetting);
}
