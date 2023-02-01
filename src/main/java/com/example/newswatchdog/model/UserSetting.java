package com.example.newswatchdog.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserSetting {

    private long id;
    private   Map<String, String> mapWebSites = new HashMap<>();
    private List<String> listFindString = new ArrayList<>();
    private String allnews ;

    public UserSetting() {
        mapWebSites.put("rbc","");
        mapWebSites.put("kp40","");
        mapWebSites.put("nikatv","");
        mapWebSites.put("znamkaluga","");
        mapWebSites.put("kaluga-poisk","");
        allnews = "";
    }

    public UserSetting(List<String> listFindString, Map<String, String> mapWebSites, String allnews ){
        this.listFindString = listFindString;
        this.mapWebSites = mapWebSites;
        this.allnews = allnews;

    }

    public  Map<String, String> getMapWebSites() {
        return mapWebSites;
    }

    public  void setMapWebSites(String rbc, String kp40,  String nikatv, String znam, String poisk) {
        mapWebSites.put("rbc",rbc);
        mapWebSites.put("kp40",kp40);
        mapWebSites.put("nikatv",nikatv);
        mapWebSites.put("znamkaluga",znam);
        mapWebSites.put("kaluga-poisk",poisk);
    }

    public  List<String> getListFindString() {
        return listFindString;
    }

    public  void setListFindString(List<String> listFindString) {
        this.listFindString = listFindString;
    }

    public long getId() {
        return id;
    }

    public String getAllnews(){
        return  this.allnews;
    }

    public  void setAllnews(String allnews){
        this.allnews = allnews;
    }

    public UserSetting clone() {
        UserSetting userSetting = new UserSetting(this.listFindString, this.mapWebSites, this.allnews);
        return  userSetting;
    }
}
