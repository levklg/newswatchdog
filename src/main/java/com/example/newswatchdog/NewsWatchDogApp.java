package com.example.newswatchdog;

import com.example.newswatchdog.service.client.NettyClient;
import com.example.newswatchdog.service.DBServiceUser;
import com.example.newswatchdog.service.DbServiceUserImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

@Component("newswatchdogapp")
@SessionAttributes(value = "user")
public class NewsWatchDogApp {


    public static DBServiceUser dbServiceUser;

    public static NettyClient nettyClient;

    public NewsWatchDogApp(DBServiceUser dbServiceUser, NettyClient nettyClient) {

        this.nettyClient = nettyClient;
        this.dbServiceUser = dbServiceUser;
    }

    public void action() {

        nettyClient = new NettyClient();
        while (true) {

            if (!nettyClient.isConnect()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (nettyClient.isConnect()) {
                break;
            }
        }
        DBServiceUser dbServiceUser = new DbServiceUserImpl(nettyClient);

    }


}
