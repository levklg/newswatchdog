package com.example.newswatchdog.controllers;

import com.example.newswatchdog.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.example.newswatchdog.NewsWatchDogApp.dbServiceUser;

@Controller
public class UserConsoleController {
public User user = null;

    @GetMapping ("/")
    public String doGet(Model model) {

     if(user == null){
         //    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     ///    String currentPrincipalName = authentication.getName();
     //    this.user = dbServiceUser.findByUserName(currentPrincipalName).get();
     }
      //  model.addAttribute("listString", user.getUserSetting().getListFindString());
        model.addAttribute("activerbk",true);
        model.addAttribute("activekp40",false);
        model.addAttribute("activekalugapoisk",false);
        model.addAttribute("activenikatv",true);
        model.addAttribute("activallnews",false);
        model.addAttribute("activecheckznamkaluga",true);

        return "userconsole";
    }

    @PostMapping("/userconsole")
    public String doPost(@RequestParam(defaultValue = "") String checkrbk, @RequestParam(defaultValue = "") String checkkp40,
                         @RequestParam(defaultValue = "") String checkkalugapoisk, @RequestParam(defaultValue = "") String checknikatv,
                         @RequestParam(defaultValue = "") String checkznamkaluga,
                         @RequestParam(defaultValue = "") String inputfindstring, @RequestParam(defaultValue = "") String listfindstring,
                         @RequestParam(defaultValue = "") String start, @RequestParam(defaultValue = "") String reset,
                         @RequestParam(defaultValue = "") String logout,  @RequestParam(defaultValue = "") String checkAllNews,  Model model) {

       if(!inputfindstring.equals("")){
           if(this.user != null) {
               this.user.getUserSetting().getListFindString().add(inputfindstring);
           }
       }
     if(reset.equals("reset")){
         if(this.user != null) {
             this.user.getUserSetting().getListFindString()
                     .removeAll(user.getUserSetting().getListFindString());
         }
     }
       if(start.equals("start")){
           if(this.user != null) {
               this.user.getUserSetting().setMapWebSites(checkrbk, checkkp40, checkkalugapoisk, checknikatv, checkznamkaluga);
               if(checkAllNews.equals("allnews")){
                 user.getUserSetting().getListFindString().add("allnews");
               }
           }
       }

       if (logout.equals("logout")){
           return "redirect:/index";
       }

        return "redirect:/";
    }

}
