package com.example.newswatchdog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping({"/", "/login"})
    public String doGet(Model model) {
    int a = 0;
        return "login";
    }

    @PostMapping({"/","/login"})
    public String doPost(Model model){
        int a = 0;
      return "userconsole"  ;
    }
}
