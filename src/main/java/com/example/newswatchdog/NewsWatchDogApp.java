package com.example.newswatchdog;

import com.example.newswatchdog.model.User;
import com.example.newswatchdog.model.UserSetting;
import com.example.newswatchdog.repository.UserRepositoryImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

@Component("newswatchdogapp")
@SessionAttributes(value = "user")
public class NewsWatchDogApp {
public  static UserRepositoryImpl userRepository = new UserRepositoryImpl();
    public void action() {

        User user = new User("Lev", 1l);
        user.setUserSetting(new UserSetting());
        userRepository.save(user);

    }
}
