package com.example.newswatchdog.controllers;

import com.example.newswatchdog.model.User;
import com.example.newswatchdog.repository.UserRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.newswatchdog.NewsWatchDogApp.userRepository;

@Controller
@RequestMapping("/")
public class UserConsoleController {


    @GetMapping ("/userconsole")
    public String doGet(Model model) {

     User user =  userRepository.getUser();
     model.addAttribute("listString", userRepository.getUser().getUserSetting().getListFindString());
        int i = 0;
        return "userconsole";
    }

    @PostMapping("/userconsole")
    public String doPost(@RequestParam(defaultValue = "") String checkrbk, @RequestParam(defaultValue = "") String checkkp40,
                         @RequestParam(defaultValue = "") String checkkaluga24, @RequestParam(defaultValue = "") String checknikatv,
                         @RequestParam(defaultValue = "") String inputfindstring, @RequestParam(defaultValue = "") String listfindstring,
                         @RequestParam(defaultValue = "") String start, Model model) {

       if(!inputfindstring.equals("")){
           userRepository.getUser().getUserSetting().getListFindString().add(inputfindstring);
       }
       userRepository.getUser().getUserSetting().setMapWebSites(checkrbk, checkkp40, checkkaluga24, checknikatv);
       if(start.equals("start")){

       }
        return "redirect:/userconsole";
    }

}
