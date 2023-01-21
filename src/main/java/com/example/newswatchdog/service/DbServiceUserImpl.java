package com.example.newswatchdog.service;


import com.example.newswatchdog.model.User;
import com.example.newswatchdog.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DbServiceUserImpl implements DBServiceUser {
    private static final Logger log = LoggerFactory.getLogger(DbServiceUserImpl.class);

    @Autowired
    private final TransactionManager transactionManager;
    @Autowired
    private final UserRepository userRepository;


    public DbServiceUserImpl(TransactionManager transactionManager, UserRepository userRepository) {
        this.transactionManager = transactionManager;
        this.userRepository = userRepository;
    }


    @Override
    public User getUser(long id) {
        var user = userRepository.findById(id);
        log.info("user: {}", user);
        return user.get();
    }

    @Override
    public List<User> findAll() {
        var userList = new ArrayList<User>();
        userRepository.findAll().forEach(userList::add);
        log.info("clientList:{}", userList);
        return userList;
    }

    @Override
    public Optional<User> findByUserName(String name) {
        var user = userRepository.findByUserName(name);
        log.info("user: {}", user);
        return user;
    }

    @Override
    public User saveUser(User user) {
            var savedClient = userRepository.save(user);
            log.info("saved user: {}", savedClient);
            return savedClient;

    }


}