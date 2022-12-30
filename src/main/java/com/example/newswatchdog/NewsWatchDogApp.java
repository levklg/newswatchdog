package com.example.newswatchdog;

import com.example.newswatchdog.model.User;
import com.example.newswatchdog.model.UserSetting;
import com.example.newswatchdog.repository.UserRepository;
import com.example.newswatchdog.service.DBServiceUser;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

@Component("newswatchdogapp")
@SessionAttributes(value = "user")
public class NewsWatchDogApp {
    private final UserRepository userRepository;

    private final DBServiceUser dbServiceClient;

    public NewsWatchDogApp(UserRepository userRepository, DBServiceUser dbServiceClient) {
        this.userRepository = userRepository;
        this.dbServiceClient = dbServiceClient;
    }

    public void action() {

        User user = new User("Lev", 1l);
        user.setUserSetting(new UserSetting());
        userRepository.save(user);


    }
}
