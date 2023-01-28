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
  //  @Autowired
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
        //        String s = new BCryptPasswordEncoder().encode("admin");
        //   System.out.println(s);
        // User user = new User("Lev", s, new UserSetting());
        //     dbServiceUser.saveUser(user);

 /*
     User usertest =  dbServiceUser.getUser(3);

        List<String> list = usertest.getUserSetting().getListFindString();

        for(var s : list){
            System.out.println(s);
        }


        var map = usertest.getUserSetting().getMapWebSites();
        for (String key : map.keySet()) {
            System.out.println(key);
        }


 */
    }


}
