package com.dumitruc.appium;


import com.dumitruc.appium.screens.*;
import com.dumitruc.appium.support.MyProperties;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by dima on 02/02/2014.
 */
public class StepDefSendPayment {

    AppiumDriver appiumDriver = AppiumDriver.getInstance();


    MyProperties properties = MyProperties.getInstance();


    SendPaymentScreen sendPaymentScreen;
    SendPaymentToCard sendPaymentToCard;
    SendConfirmationScreen sendConfirmationScreen;
    PaymentConfirmationScreen paymentConfirmationScreen;

    Actor tester = Actor.getInstance();

    Scenario scenario;


    @When("^I send (\\S+) <currency> payment to (.*) that has the card (\\S+)$")
    public void sendPaymentToCard(String amount, String recipientName, String cardNumber) throws Throwable {
        CardsScreen cardsScreen = (CardsScreen) tester.getCurrentScreen();
        //[... other actions]

    }

    @When("^add a (.*)$")
    public void addNote(String note) throws Throwable {
        appiumDriver.swipe();
        //[... other actions]
    }

    @When("^press send$")
    public void pressSend() throws Throwable {
        appiumDriver.swipe();
        //[... other actions]
    }

    @Then("^I get a payment confirmation screen containing the transaction ID$")
    public void checkConfirmationScreen() throws Throwable {
        //[... other actions]
    }

    @When("^I send  (\\S+) <currency> payment to (.*) that is (not )?registered for the service$")
    public void sendToMsisdn(String amount, String phoneNr) throws Throwable {
        // Express the Regexp above with the code you wish you had
    }

}
