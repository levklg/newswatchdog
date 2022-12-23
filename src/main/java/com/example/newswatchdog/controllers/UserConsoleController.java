package com.example.newswatchdog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
@SessionAttributes("getList")
@RequestMapping("/")
public class UserConsoleController {
    @GetMapping({"/", "/userconsole"})
    public String doGet(Model model) {

        return "userconsole";
    }

    @PostMapping({"/", "/userconsole"})
    public String doPost(@RequestParam(defaultValue = "") String clientName, @RequestParam(defaultValue = "") String clientPhone,
                         @RequestParam(defaultValue = "") String address, @RequestParam(defaultValue = "") String buttonGetList,
                         @RequestParam(defaultValue = "") String buttonCreateClient, Model model) {



        return "redirect:/userconsole";
    }

}
