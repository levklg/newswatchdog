package com.example.newswatchdog.model;

public class User {
    private String nickname = "";
    private long ID;
    private UserSetting userSetting;

    public User(String nickname, long ID){
        this.nickname = nickname;
        this.ID = ID;
    }

    public void setUserSetting(UserSetting userSetting) {
        this.userSetting = userSetting;
    }

    public UserSetting getUserSetting() {
        return userSetting;
    }
}
