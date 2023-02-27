package com.test.openmrs.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", //content
        glue = "com/test/openmrs/stepdefinitions", //source
        dryRun = false, //get snips without executing the code
        tags = "@regression",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt",
                "json:target/cucumber-reports/cucumber.json"}
)
public class Runner {
}
