package com.example.newswatchdog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class NewswatchdogApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(NewswatchdogApplication.class, args);
		context.getBean("newswatchdogapp", NewsWatchDogApp.class).action();
	}

}
