package com.example.newswatchdog;

import com.example.newswatchdog.model.User;
import com.example.newswatchdog.repository.UserRepository;
import com.example.newswatchdog.service.DBServiceUser;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Component("newswatchdogapp")
@SessionAttributes(value = "user")
public class NewsWatchDogApp {

    public static UserRepository userRepository = null;
    public static DBServiceUser dbServiceUser;

    public NewsWatchDogApp(UserRepository userRepository, DBServiceUser dbServiceUser) {
        this.userRepository = userRepository;

        this.dbServiceUser = dbServiceUser;
    }

    public void action() {

   //        String s = new BCryptPasswordEncoder().encode("admin");
    //   System.out.println(s);
 //     User user = new User("Lev", s, new UserSetting());
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
