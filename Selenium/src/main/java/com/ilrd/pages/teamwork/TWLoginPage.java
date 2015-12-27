package com.ilrd.pages.teamwork;

import com.ilrd.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 23/12/15.
 */
public class TWLoginPage extends BasePage{


    @FindBy(id = "userLogin")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "ordLoginSubmitBtn")
    private WebElement loginButton;

    public TWLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //check if in login page
        driver.findElement(By.id("ordLoginSubmitBtn"));

    }


    public TWLoginPage typeUserName(String text) {

        userName.sendKeys(text);
        return this;

    }

    public TWLoginPage typePassword(String text) {

        password.sendKeys(text);
        return this;

    }

    public TWOverviewPage login() {
        loginButton.click();
        return new TWOverviewPage(driver);
    }


    public TWOverviewPage loginAs(String userName, String password) {

        typeUserName(userName);
        typePassword(password);
        return login();

    }

    public TWLoginPage loginAsExpectingError(String userName, String password) {

        typeUserName(userName);
        typePassword(password);
        loginButton.click();
        return new TWLoginPage(driver);


    }
}
