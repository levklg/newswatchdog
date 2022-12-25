package com.example.newswatchdog.model;

import java.util.HashMap;
import java.util.Map;

public class WebSites {
    private  static Map<String, String> mapWebSites = new HashMap<>();

    public WebSites(){
        mapWebSites.put("https://www.rbc.ru/","0");
        mapWebSites.put("https://www.kp40.ru/","0");
        mapWebSites.put("https://kaluga24.tv/home/news","0");
        mapWebSites.put("https://nikatv.ru/news/lenta","0");
    }

    public static Map<String, String> getMapWebSites() {
        return mapWebSites;
    }

    public static void setMapWebSites(Map<String, String> mapWebSites) {
        WebSites.mapWebSites = mapWebSites;
    }
}
