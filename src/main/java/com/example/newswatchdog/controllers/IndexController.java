package com.example.newswatchdog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping( "/index")
    public String indexGet(Model model, String error, String login) {
        return "index";
    }

}
