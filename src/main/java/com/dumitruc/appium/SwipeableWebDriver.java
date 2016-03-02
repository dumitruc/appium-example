package com.dumitruc.appium;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.RemoteTouchScreen;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by dima on 13/12/2013.
 */
public class SwipeableWebDriver extends RemoteWebDriver implements HasTouchScreen {
    private RemoteTouchScreen touch;


    public SwipeableWebDriver() {
    }

    public SwipeableWebDriver (URL remoteAddress, Capabilities desiredCapabilities){
        super(remoteAddress, desiredCapabilities);
        touch = new RemoteTouchScreen(getExecuteMethod());
    }

    public TouchScreen getTouch(){
        return touch;
    }


}
