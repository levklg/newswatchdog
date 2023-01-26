package com.example.newswatchdog.service;


import com.example.newswatchdog.grpc.ChangedUserSettingsServiceGrpc;
import com.example.newswatchdog.grpc.Empty;
import com.example.newswatchdog.grpc.UserName;
import io.grpc.stub.StreamObserver;


public class ChangedUserSettingsServiceImp extends ChangedUserSettingsServiceGrpc.ChangedUserSettingsServiceImplBase {


    @Override
    public void sendChangedUserSettings(com.example.newswatchdog.grpc.UserName request,
                                        io.grpc.stub.StreamObserver<com.example.newswatchdog.grpc.Empty> responseObserver){


        System.out.println("Send:  " + request);
        responseObserver.onNext(null);
        responseObserver.onCompleted();

    }


    @Override
    public void reciveChangedUserSettings(com.example.newswatchdog.grpc.Empty request,
                                          io.grpc.stub.StreamObserver<com.example.newswatchdog.grpc.UserName> responseObserver) {
        UserName response = UserName.newBuilder()

                .build();

        responseObserver.onNext(response);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Recive: " + response.getUserName());

        responseObserver.onCompleted();

    }

}
