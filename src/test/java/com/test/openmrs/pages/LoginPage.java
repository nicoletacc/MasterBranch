package com.test.openmrs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//ul[@id='sessionLocation']//li")
    List<WebElement> locations;
    @FindBy(css = "#loginButton")
    WebElement loginButton;
    @FindBy(css = "#error-message")
    WebElement errorMessage;

    public void login(String username, String password, String location){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        for (WebElement loc: locations){
            if(BrowserUtils.getText(loc).equals(location)){
                loc.click();
                break;
            }
        }
        loginButton.click();
    }
    public String validateMessage(){
        return BrowserUtils.getText(errorMessage);
    }

}
