package com.example.newswatchdog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/")
public class UserConsoleController {
    @GetMapping({"/", "/userconsole"})
    public String doGet(Model model) {

        int i = 0;
        return "userconsole";
    }

    @PostMapping("/userconsole")
    public String doPost(@RequestParam(defaultValue = "") String checkrbk, @RequestParam(defaultValue = "") String checkkp40,
                         @RequestParam(defaultValue = "") String checkkaluga24, @RequestParam(defaultValue = "") String checknikatv,
                         @RequestParam(defaultValue = "") String inputfindstring, @RequestParam(defaultValue = "") String listfindstring, Model model) {

        int i = 0;

        return "userconsole";
    }

}
