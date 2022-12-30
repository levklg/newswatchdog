package com.example.newswatchdog.model;


import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usersetting_id")
    private UserSetting userSetting;

    private String username;

    private String password;

    public User(){

    }

    public User(String username, long id){
        this.username = username;
        this.id = id;
    }

    public void setUserSetting(UserSetting userSetting) {
       this.userSetting = userSetting;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

   public UserSetting getUserSetting() {
        return userSetting;

    }
}
