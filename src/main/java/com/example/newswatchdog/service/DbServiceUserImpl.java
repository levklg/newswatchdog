package com.example.newswatchdog.service;


import com.example.newswatchdog.model.User;
import com.example.newswatchdog.repository.UserRepository;
import com.example.newswatchdog.sessionmanager.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DbServiceUserImpl implements DBServiceUser {
    private static final Logger log = LoggerFactory.getLogger(DbServiceUserImpl.class);

    private final TransactionManager transactionManager;
    private final UserRepository userRepository;

    public DbServiceUserImpl(TransactionManager transactionManager, UserRepository userRepository) {
        this.transactionManager = transactionManager;
        this.userRepository = userRepository;
    }


    @Override
    public User saveUser(User user) {
        return transactionManager.doInTransaction(() -> {
            var savedClient = userRepository.save(user);
            log.info("saved client: {}", savedClient);
            return savedClient;
        });
    }

    @Override
    public User getUser(long id) {
        var userOptional = userRepository.findById(id);
        log.info("client: {}", userOptional);
        return userOptional;
    }

    @Override
    public List<User> findAll() {
        var userList = new ArrayList<User>();
        userRepository.findAll().forEach(userList::add);
        log.info("clientList:{}", userList);
        return userList;
    }
}
