package com.example.newswatchdog.model;


public class User {

    private long id;
    private String userName;
    private String password;
    private long telegramID;
    private UserSetting userSetting;

    public User(){

    }

    public User(String name, String password, UserSetting userSetting) {
        this.userName = name;
        this.password = password;
        this.userSetting = userSetting;
    }

    public User(String name, String password) {
        this.userName = name;
        this.password = password;
    }

    @Override
    public User clone() {
        User user = new User(this.userName, this.password,  this.userSetting);

        return  user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserSetting getUserSetting() {
        return  userSetting;

    }

    public void setUserSetting(UserSetting userSetting) {
        this.userSetting = userSetting;
    }
}
