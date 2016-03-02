package com.dumitruc.appium.support;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by dima on 14/12/2013.
 */
public class MyProperties {
    private static final Properties myProperties = new Properties();
    private static MyProperties propertiesInstance = null;

    private static final String fileName = "config.properties";

    protected MyProperties(){
        try{
            myProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName));
        }catch (IOException e){
            System.out.println("Could not load the properties: "+fileName);
            e.printStackTrace();
        }

    }

    public static MyProperties getInstance(){
        if (propertiesInstance == null){
            propertiesInstance = new MyProperties();
        }

        return propertiesInstance;
    }

    public static String getProperty(String key){
        return myProperties.getProperty(key);
    }

    public static void setProperty(String key, String value){
        setProperty(key, value);
    }
}
