package com.example.newswatchdog.controllers;

import com.example.newswatchdog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import static com.example.newswatchdog.NewsWatchDogApp.userRepository;

@Controller
@RequestMapping("/")
public class UserConsoleController {


    @GetMapping ("/userconsole")
    public String doGet(Model model) {

   //  User user =  userRepository.getUser();
   //  model.addAttribute("listString", userRepository.getUser().getUserSetting().getListFindString());
       model.addAttribute("activerbk",true);
        model.addAttribute("activekp40",false);
        model.addAttribute("activekaluga24",false);
        model.addAttribute("activenikatv",true);
        return "userconsole";
    }

    @PostMapping("/userconsole")
    public String doPost(@RequestParam(defaultValue = "") String checkrbk, @RequestParam(defaultValue = "") String checkkp40,
                         @RequestParam(defaultValue = "") String checkkaluga24, @RequestParam(defaultValue = "") String checknikatv,
                         @RequestParam(defaultValue = "") String inputfindstring, @RequestParam(defaultValue = "") String listfindstring,
                         @RequestParam(defaultValue = "") String start, @RequestParam(defaultValue = "") String reset,
                         @RequestParam(defaultValue = "") String logout, Model model) {

       if(!inputfindstring.equals("")){
   //        userRepository.getUser().getUserSetting().getListFindString().add(inputfindstring);
       }
     if(reset.equals("reset")){
    //     userRepository.getUser().getUserSetting().getListFindString()
    //             .removeAll(userRepository.getUser().getUserSetting().getListFindString());
     }
       if(start.equals("start")){
     //      userRepository.getUser().getUserSetting().setMapWebSites(checkrbk, checkkp40, checkkaluga24, checknikatv);
       }

       if (logout.equals("logout")){
           return "redirect:/login";
       }
        return "redirect:/userconsole";
    }

}
