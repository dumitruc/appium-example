package com.dumitruc.appium;

import com.dumitruc.appium.support.MyProperties;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dima on 16/02/2014.
 */
public class Applications {

    List<Application> apps;
    Gson gson = new Gson();

    public Applications() throws FileNotFoundException {

        File jsonFile = new File(MyProperties.getInstance().getProperty("android.apps.json"));
        Scanner scanner = new Scanner(jsonFile);
        String text = scanner.useDelimiter("\\A").next();

        Type type = new TypeToken<List<Application>>() {
        }.getType();

        List<Application> apps = gson.fromJson(text, type);
        setApp(apps);
    }

    public void setApp(List<Application> apps) {
        this.apps = apps;
    }

    public List<Application> getApps() {
        return apps;
    }

    public Application getAppByName(String appName) throws Exception {
        Application app = null;

        for (Application theApp : apps) {
            if (theApp.getName().equals(appName)) {
                app = theApp;
                break;
            }

        }

        if (app == null) {
            throw new Exception("Could not find specified app " + appName);
        }

        return app;
    }
}
