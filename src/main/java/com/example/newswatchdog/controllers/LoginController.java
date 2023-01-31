package com.example.newswatchdog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping( "/login")
    public String login(Model model, String error, String logout) {
          return   "login";
    }

}
