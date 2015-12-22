package com.ilrd.pages.sugarcrm;

import com.ilrd.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 22/12/15.
 */
public class SugarLogin extends BasePage {

    @FindBy(id = "user_name")
    private WebElement userName;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(id = "login_button")
    private WebElement loginButton;

    public SugarLogin(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //check if in login page
        driver.findElement(By.id("login_button"));

    }


    public SugarLogin typeUserName(String text) {

        userName.sendKeys(text);
        return this;

    }

    public SugarLogin typePassword(String text) {

        password.sendKeys(text);
        return this;

    }

    public SugarHomePage login() {
        loginButton.click();
        return new SugarHomePage(driver);
    }

    public SugarHomePage loginAs(String userName, String password) {

        typeUserName(userName);
        typePassword(password);
        return login();

    }

    public SugarLogin loginAsExpectingError(String userName, String password) {

        typeUserName(userName);
        typePassword(password);
        loginButton.click();
        return new SugarLogin(driver);


    }


}
