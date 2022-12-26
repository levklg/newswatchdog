package com.example.newswatchdog.repository;

import com.example.newswatchdog.model.User;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<User> usersList = new ArrayList<>();
    private static User user = new User("Lev", 1l);

    public UserRepositoryImpl() {

  //   usersList.add(new User("Lev", 1l));

     //   clients.add(new Client(idGenerator.generateId(), "Брэндон Смит"));
    }

    @Override
    public List<User> findAll() {
        return usersList;
    }

    @Override
    public void save(User user) {
    usersList.add(user);

    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public User getUser() {
        return usersList.get(0);
    }
}
