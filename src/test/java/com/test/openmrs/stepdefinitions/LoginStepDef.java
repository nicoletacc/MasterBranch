package com.test.openmrs.stepdefinitions;

import com.test.openmrs.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginStepDef {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    @Given("User navigates to the OpenMrs web application and provide credentials and location {string}")
    public void user_navigates_to_the_open_mrs_web_application_and_provide_credentials_and_location(String location) {
        loginPage.login(ConfigReader.readProperty("QA_username"),ConfigReader.readProperty("QA_password"),location);
    }
    @Then("User validates the title {string} and {string}")
    public void user_validates_the_title_and(String expectedTitle, String expectedUrl) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl().trim());
    }
    @Given("User navigates to the OpenMrs web applications and provides credentials {string}, {string} and location {string}")
    public void user_navigates_to_the_open_mrs_web_applications_and_provides_credentials_and_location(String username, String password, String location) {
       loginPage.login(username,password,location);
    }
    @Then("User validates the errors message {string}")
    public void user_validates_the_errors_message(String expectedMessage) {
       Assert.assertEquals(expectedMessage,loginPage.validateMessage());
    }
}
