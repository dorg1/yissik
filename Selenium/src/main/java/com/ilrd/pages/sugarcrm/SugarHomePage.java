package com.ilrd.pages.sugarcrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 22/12/15.
 */
public class SugarHomePage extends BaseSugarPage {

    public SugarHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

        //check if it actually homePage
        driver.findElement(By.id("welcome"));
    }

}
