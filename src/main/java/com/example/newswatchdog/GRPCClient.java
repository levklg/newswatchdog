package com.example.newswatchdog;



import com.example.newswatchdog.grpc.ChangedUserSettingsServiceGrpc;
import com.example.newswatchdog.grpc.UserName;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class GRPCClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8190;

    private static AtomicInteger reciveVariable = new AtomicInteger(0);
    private static int lastVariable = 0;


    public static void main(String[] args) throws InterruptedException {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext()
                .build();

        var stubBlock = ChangedUserSettingsServiceGrpc.newBlockingStub(channel);

        UserName request = UserName.newBuilder()
                .setUserName("Leva")
                .build();
        var latch = new CountDownLatch(1);
        stubBlock.sendChangedUserSettings(request);
        latch.await();
        channel.shutdown();

    }

}
