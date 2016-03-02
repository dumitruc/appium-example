package com.dumitruc.appium;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by dima on 14/12/2013.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@registration", "~@login,~@wip"},
        features = ".",
        format = {"json:/Users/dima/IdeaProjects/cucumber-json2report/data/cucumber.json", "html:/Users/dima/IdeaProjects/cucumber-json2report/data/"}
)

public class StepDefinitionLoginRunnerTest {
}
