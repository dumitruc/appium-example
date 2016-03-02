package com.dumitruc.appium.screens;

import com.dumitruc.appium.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dima on 13/12/2013.
 */
public abstract class BaseMobileScreen {

    AppiumDriver appiumDriver;

    public BaseMobileScreen() {

        try {
            appiumDriver = AppiumDriver.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageFactory.initElements(appiumDriver, this);
    }


}
