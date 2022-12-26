package com.example.newswatchdog.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserSetting {
    private  static Map<String, String> mapWebSites = new HashMap<>();
    private static List<String> listFindString = new ArrayList<>();

    public UserSetting() {
        mapWebSites.put("https://www.rbc.ru/","");
        mapWebSites.put("https://www.kp40.ru/","");
        mapWebSites.put("https://kaluga24.tv/home/news","");
        mapWebSites.put("https://nikatv.ru/news/lenta","");
    }

    public  Map<String, String> getMapWebSites() {
        return mapWebSites;
    }

    public  void setMapWebSites(String rbc, String kp40, String kaluga24, String nikatv) {
        mapWebSites.put("https://www.rbc.ru/",rbc);
        mapWebSites.put("https://www.kp40.ru/",kp40);
        mapWebSites.put("https://kaluga24.tv/home/news",kaluga24);
        mapWebSites.put("https://nikatv.ru/news/lenta",nikatv);
    }

    public  List<String> getListFindString() {
        return listFindString;
    }

    public  void setListFindString(List<String> listFindString) {
        UserSetting.listFindString = listFindString;
    }
}
