package com.example.newswatchdog.model;


import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;


    @OneToOne( cascade = CascadeType.ALL,  fetch = FetchType.EAGER, orphanRemoval=true)
    @JoinColumn(name = "usersetting_id")
    private UserSetting userSetting;



    public User(){

    }


    public User(String name, String password, UserSetting userSetting) {
        this.name = name;
        this.password = password;
        this.userSetting = userSetting;
    }



    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public User clone() {
        User user = new User(this.name, this.password,  this.userSetting);

        return  user;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
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
