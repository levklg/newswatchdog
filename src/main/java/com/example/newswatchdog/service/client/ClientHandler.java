package com.example.newswatchdog.service.client;


import com.example.newswatchdog.model.User;
import com.google.gson.Gson;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.BlockingQueue;


public class ClientHandler extends SimpleChannelInboundHandler<String> {
    BlockingQueue blockingQueue;
    private User user;

    public ClientHandler(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {

        Gson gson = new Gson();
        String stringUser = "";
        if (s.startsWith("/")) {
            if (s.startsWith("/findByName")) {
                stringUser = s.split("\\ ", 2)[1];
                this.user = gson.fromJson(stringUser, User.class);
                this.blockingQueue.add(user);
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("Server disconnect");
        ctx.close();
    }

}