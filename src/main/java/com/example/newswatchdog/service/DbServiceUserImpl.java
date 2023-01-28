package com.example.newswatchdog.service;


import com.example.newswatchdog.service.client.NettyClient;
import com.example.newswatchdog.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbServiceUserImpl implements DBServiceUser {
    private static final Logger log = LoggerFactory.getLogger(DbServiceUserImpl.class);


    @Autowired
    NettyClient nettyClient;

    public DbServiceUserImpl( NettyClient nettyClient) {

        this.nettyClient = nettyClient;
    }


    @Override
    public void updateUser(User user) {
        nettyClient.updateUser(user);
    }

    @Override
    public User findByUserName(String name) {
        var user = nettyClient.findByUserName(name);
        log.info("user: {}", user);
        return user;
    }




}