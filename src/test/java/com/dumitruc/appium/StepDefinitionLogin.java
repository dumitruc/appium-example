package com.dumitruc.appium;

import com.dumitruc.appium.screens.LoginScreen;
import com.dumitruc.appium.screens.CardsScreen;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by dima on 14/12/2013.
 */
public class StepDefinitionLogin {

    Scenario scenario;
    AppiumDriver appiumDriver = AppiumDriver.getInstance();
    Application appToStart;
    Actor tester = Actor.getInstance();

    @Before
    public void startTest(Scenario scenario) throws Exception {
        System.out.println("Starting...");
        this.scenario = scenario;
        tester.remember("scenario", scenario);
    }

    @After
    public void endTest() throws Exception {

        if (scenario.isFailed()) {
            //TODO treat it here.
            scenario.embed(AppiumDriver.baScreenShot(), "image/png");
        }

        try {
            appiumDriver.tearDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Ending...");
    }


    @Given("^I have the (.*) configured on the Android device$")
    public void iHaveAppInstalled(String issuerName) throws Throwable {
        Applications configuredApps = new Applications();
        appToStart = configuredApps.getAppByName(issuerName);
        assertTrue("Could not find the configuration for the application: " + issuerName + ". Check *-applications.json config file",
                appToStart != null);

    }

    @When("^I launch the application$")
    public void launchTheApplication() throws Throwable {
        appiumDriver.startApplication(appToStart);
    }

    @Then("^Login screen is displayed$")
    public void checkLoginScreen() throws Throwable {
        LoginScreen loginScreen = new LoginScreen();
        //[... other actions]
    }

    @When("^I enter the valid passcode (.*) into the app$")
    public void enterLogin(String passcode) throws Throwable {
        LoginScreen loginScreen = new LoginScreen();
        //[... other actions]
        scenario.embed(AppiumDriver.baScreenShot(), "image/png");
    }

    @When("^I enter the invalid passcode (.*) into the app$")
    public void I_enter_the_incorrect_PassCode_into_the_app(String passcode) throws Throwable {
    }

    @Then("^The app is \"([^\"]*)\" screen is displayed$")
    public void The_app_is_screen_is_displayed(String arg1) throws Throwable {
        System.out.println("Screen is loading (still to code) " + arg1);

    }

    @And("^I am logged in into the app$")
    public void I_am_logged_in_into_the_app() throws Throwable {
        System.out.println("Screen is laoded ");
    }

    @Then("^The \"Invalid Details\" screen is displayed$")
    public void The_screen_is_displayed() throws Throwable {

    }

    @And("^the OK button is enabled$")
    public void the_OK_button_is_enabled() throws Throwable {
        // Express the Regexp above with the code you wish you had
    }

    @When("^I press the OK button$")
    public void I_press_the_OK_button() throws Throwable {
    }

    @Then("^I am presented with the login screen$")
    public void I_am_presented_with_the_login_screen() throws Throwable {
    }

    @When("^I log in into the app$")
    public void loginIntoTheApp() throws Throwable {
        launchTheApplication();
        checkLoginScreen();
        enterLogin("14789");

    }

    @Then("^Cards screen is displayed$")
    public void screen_is_displayed() throws Throwable {
        CardsScreen cardsScreen = new CardsScreen();
        //[... other actions]
        tester.setCurrentScreen(cardsScreen);
    }

    @Given("^My issuer (.*) has completed the necessary back end  registration steps$")
    public void checkAppInstalled(String issuerName) throws Throwable {
        //Manual check for now, we can not really check the back end as a prerequisite
        Applications configuredApps = new Applications();
        appToStart = configuredApps.getAppByName(issuerName);
        assertTrue("Could not find the configuration for the application: " + issuerName + ". Check *-applications.json config file",
                appToStart != null);

    }
}
