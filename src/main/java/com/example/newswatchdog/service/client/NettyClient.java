package com.example.newswatchdog.service.client;


import com.example.newswatchdog.model.User;
import com.google.gson.Gson;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class NettyClient {

    private static final String HOST = "localhost";
    private static final int PORT = 8123;
    public static BlockingQueue blockingQueue = new LinkedBlockingDeque<User>(1);
    private static SocketChannel socketChannel;
    List<User> userList = new ArrayList<>();
    User user;
    ClientHandler clientHandler;


    public NettyClient() {


        Thread thread = new Thread(
                () -> {
                    clientHandler = new ClientHandler(blockingQueue);
                    EventLoopGroup workerGroup = new NioEventLoopGroup();
                    try {
                        Bootstrap b = new Bootstrap();
                        b.group(workerGroup);
                        b.channel(NioSocketChannel.class);
                        b.handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            public void initChannel(SocketChannel ch) throws Exception {
                                ch.pipeline().addLast(new StringDecoder(), new StringEncoder(), clientHandler);
                                socketChannel = ch;
                            }
                        });
                        ChannelFuture f = b.connect(HOST, PORT).sync();
                        f.channel().closeFuture().sync();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {

                        workerGroup.shutdownGracefully();
                    }

                });
        thread.setDaemon(true);
        thread.start();


    }

    public User findByUserName(String userName) {

        StringBuilder stringBuilder = new StringBuilder();
        var sendString = stringBuilder.append("/findByName ").append(userName);
        sendMessageToServer(sendString.toString());
        Object user = null;
        try {
            user = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (User) user;
    }

    public void updateUser(User user) {
        Gson gson = new Gson();
        String gsonUser = gson.toJson(user);
        StringBuilder stringBuilder = new StringBuilder();
        var sendString = stringBuilder.append("/updateUser ").append(gsonUser);
        sendMessageToServer(sendString.toString());
    }

    public void sendMessageToServer(String str) {
        if (socketChannel != null) {
            socketChannel.writeAndFlush(str);
        }
    }

    public boolean isConnect() {
        if (socketChannel != null) {
            return socketChannel.isActive();
        } else {
            return false;
        }
    }

    public void close(){
        socketChannel.close();
    }
}
