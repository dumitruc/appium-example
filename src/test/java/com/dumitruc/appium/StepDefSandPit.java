package com.dumitruc.appium;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by dima on 06/02/2014.
 */
public class StepDefSandPit {

    Scenario scenario;

    @Before("@sandpit")
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^the test execution is complete$")
    public void execComplete() throws Throwable {
        System.out.println("Execution completed");
    }

    @When("^report is created$")
    public void reportCreated() throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("Report created");

        scenario.write("Here is some more text for you!");
    }

    @Then("^is all done$")
    public void done() throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("we're done!");
    }
}
