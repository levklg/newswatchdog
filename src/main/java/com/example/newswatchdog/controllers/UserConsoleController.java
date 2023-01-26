package com.example.newswatchdog.controllers;

import com.example.newswatchdog.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

import static com.example.newswatchdog.NewsWatchDogApp.dbServiceUser;

@Controller
public class UserConsoleController {
  //  public User user = null;

    @GetMapping("/")
    public String doGet(@ModelAttribute User user, HttpSession session, Model model) {

      //  if (user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            user = dbServiceUser.findByUserName(currentPrincipalName).get();
            session.setAttribute("user", user);
    //    }
        initializationUserSettings(user, model);

       return "userconsole";
    }

    @PostMapping("/userconsole")
    public String doPost(@ModelAttribute User user, HttpSession session, SessionStatus status,
                         @RequestParam(defaultValue = "") String checkrbk, @RequestParam(defaultValue = "") String checkkp40,
                         @RequestParam(defaultValue = "") String checkkalugapoisk, @RequestParam(defaultValue = "") String checknikatv,
                         @RequestParam(defaultValue = "") String checkznamkaluga,
                         @RequestParam(defaultValue = "") String inputfindstring, @RequestParam(defaultValue = "") String findstring,
                         @RequestParam(defaultValue = "") String start, @RequestParam(defaultValue = "") String reset,
                         @RequestParam(defaultValue = "") String logout, @RequestParam(defaultValue = "") String checkAllNews, Model model) {

        user = (User) session.getAttribute("user");
        List<String> listInputFindString =  new ArrayList<>();
        if (!inputfindstring.equals("")) {
            if (user != null) {
                listInputFindString.add(inputfindstring);
                user.getUserSetting().getListFindString().addAll(listInputFindString);
                model.addAttribute("listString",listInputFindString);
            }
        }
        if (reset.equals("reset")) {
            if (user != null) {
                user.getUserSetting().getListFindString()
                        .removeAll(user.getUserSetting().getListFindString());
            }
        }
        if (start.equals("start")) {
            if (user != null) {
                user.getUserSetting().setMapWebSites(checkrbk, checkkp40,checknikatv , checkznamkaluga,checkkalugapoisk );
                if (checkAllNews.equals("allnews")) {
                    user.getUserSetting().setAllnews(true);
                }

            }
            dbServiceUser.saveUser(user);
        }

        if (logout.equals("logout")) {
            status.setComplete();
            session.removeAttribute("user");
         //   session.removeAttribute("activecheckznamkaluga");
        ///    session.removeAttribute("activerbk");
        //    session.removeAttribute("activekp40");
         //   session.removeAttribute("activenikatv");
         //   session.removeAttribute("activekalugapoisk");

            return "redirect:/index";
        }

        return "redirect:/";
    }


    public void initializationUserSettings(User user, Model model) {
        model.addAttribute("listString", user.getUserSetting().getListFindString());

        var mapUser = user.getUserSetting().getMapWebSites();

        for (var map : mapUser.entrySet()) {
            var nameWebSite = map.getKey();
            var webSiteValue = map.getValue();
            if (nameWebSite.equals("rbc")) {
                if (webSiteValue.equals("1")) {
                    model.addAttribute("activerbk", true);
                } else {
                    model.addAttribute("activerbk", false);
                }
            }

            if (nameWebSite.equals("kp40")) {
                if (webSiteValue.equals("1")) {
                    model.addAttribute("activekp40", true);
                } else {
                    model.addAttribute("activekp40", false);
                }
            }

            if (nameWebSite.equals("nikatv")) {
                if (webSiteValue.equals("1")) {
                    model.addAttribute("activenikatv", true);
                } else {
                    model.addAttribute("activenikatv", false);
                }
            }

            if (nameWebSite.equals("znamkaluga")) {
                if (webSiteValue.equals("1")) {
                    model.addAttribute("activecheckznamkaluga", true);
                } else {
                    model.addAttribute("activecheckznamkaluga", false);
                }
            }

            if (nameWebSite.equals("kaluga-poisk")) {
                if (webSiteValue.equals("1")) {
                    model.addAttribute("activekalugapoisk", true);
                } else {
                    model.addAttribute("activekalugapoisk", false);
                }
            }


            if (user.getUserSetting().isAllnews()) {
                model.addAttribute("activallnews", true);
            } else {
                model.addAttribute("activallnews", false);
            }
        }

    }

}
