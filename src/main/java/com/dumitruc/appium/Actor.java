package com.dumitruc.appium;

import com.dumitruc.appium.screens.BaseMobileScreen;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by dima on 06/03/2014.
 */
public class Actor {

    public BaseMobileScreen screen;

    private Object currentScenario;//quick hack
    private static Actor instance;


    private Map<String, Object> localCache = new HashMap<String, Object>();

    protected Actor() {

    }

    public static Actor getInstance() {
        if (instance == null) {
            instance = new Actor();
        }
        return instance;
    }


    public void setCurrentScreen(BaseMobileScreen screen){
        this.screen = screen;
    }

    public BaseMobileScreen getCurrentScreen(){
        return screen;
    }


    public void remember(String key, Object obj){
        localCache.put(key, obj);
    }

    public  Object recall(String key){
        return localCache.get(key);

    }
}
