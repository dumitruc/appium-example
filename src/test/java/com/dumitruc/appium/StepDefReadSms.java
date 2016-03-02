package com.dumitruc.appium;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by dima on 16/02/2014.
 */
public class StepDefReadSms {


    AppiumDriver appiumDriver;

    @Before
    public void startApp() throws Exception {

    }

    @When("^I open the SMS application$")
    public void I_open_the_SMS_application() throws Throwable {
        System.out.println("Switch the app");
        appiumDriver = AppiumDriver.getInstance();
    }

    @Then("^I can read a SMS$")
    public void I_can_read_a_SMS() throws Throwable {
        // Express the Regexp above with the code you wish you had
        Thread.sleep(50000);
    }

}
