package com.example.newswatchdog;

import com.example.newswatchdog.model.User;
import com.example.newswatchdog.model.UserSetting;
import com.example.newswatchdog.service.DBServiceUser;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Component("newswatchdogapp")
@SessionAttributes(value = "user")
public class NewsWatchDogApp {


    private final DBServiceUser dbServiceUser;

    public NewsWatchDogApp( DBServiceUser dbServiceUser) {

        this.dbServiceUser = dbServiceUser;
    }

    public void action() {
  /*
        User user = new User("Lev", "admin", new UserSetting());
        dbServiceUser.saveUser(user);

    */
     User usertest =  dbServiceUser.getUser(1);

        List<String> list = usertest.getUserSetting().getListFindString();
        System.out.println(list.size());
        for(var s : list){
            System.out.println(s);
        }


        var map = usertest.getUserSetting().getMapWebSites();
        for (String key : map.keySet()) {
            System.out.println(key);
        }

    }


}
