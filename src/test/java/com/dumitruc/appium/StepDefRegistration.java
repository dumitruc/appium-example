package com.dumitruc.appium;

import com.dumitruc.appium.screens.RegistrationWelcomeScreen;
import com.dumitruc.appium.screens.TermsAndConditionsScreen;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by dima on 27/05/2014.
 */
public class StepDefRegistration {

    AppiumDriver appiumDriver = AppiumDriver.getInstance();
    Actor tester = Actor.getInstance();

    @Then("^the registration welcome screen is displayed$")
    public void registrationScreenLoaded() throws Throwable {
        RegistrationWelcomeScreen registrationWelcomeScreen = new RegistrationWelcomeScreen();
        //[... other actions]
        ((Scenario) tester.recall("scenario")).embed(AppiumDriver.baScreenShot(), "image/png");
        tester.remember("registrationWelcomeScreen", registrationWelcomeScreen);
    }

    @And("^has the welcome message message (.*)")
    public void checkWelcomeMessage(String expectedMessage) throws Throwable {
        //[... other actions]
        ((Scenario) tester.recall("scenario")).embed(AppiumDriver.baScreenShot(), "image/png");
    }

    @When("^I press Continue button$")
    public void I_press_Continue_button() throws Throwable {

        TermsAndConditionsScreen termsAndConditionsScreen;
        //[... other actions]
    }

    @Then("^I am presented with terms and conditions screen$")
    public void isTsAndCsScreenLoaded() throws Throwable {
        TermsAndConditionsScreen termsAndConditionsScreen = (TermsAndConditionsScreen) tester.getCurrentScreen();
        ((Scenario) tester.recall("scenario")).embed(AppiumDriver.baScreenShot(), "image/png");
        //[... other actions]
    }

    @And("^the \"I Accept\" button is disabled$")
    public void isIAcceptEnabled() throws Throwable {
        TermsAndConditionsScreen termsAndConditionsScreen = (TermsAndConditionsScreen) tester.getCurrentScreen();
        //[... other actions]
    }

    @When("^I scroll down through the text$")
    public void scrollUpTCs() throws Throwable {
        TermsAndConditionsScreen termsAndConditionsScreen = (TermsAndConditionsScreen) tester.getCurrentScreen();
        //[... other actions]
    }
}
