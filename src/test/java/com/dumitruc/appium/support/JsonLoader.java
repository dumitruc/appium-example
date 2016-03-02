package com.dumitruc.appium.support;


import com.dumitruc.appium.Application;
import com.dumitruc.appium.Applications;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by dima on 16/02/2014.
 */
public class JsonLoader {

    @Test
    public void loadJson() throws IOException {

        Applications applications = new Applications();


        for (Application application : applications.getApps()) {
            System.out.println("App name: " + application.getName());
        }


    }
}
