package org.openqa.selenium.example;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by soda on 21/12/15.
 */
public class UsingGoogleSearchPage {

    private static final FirefoxDriver driver = new FirefoxDriver();


    public static void main(String[] args) {

        driver.get("http://www.google.com");
        GoogleSearchPage p = PageFactory.initElements(driver, GoogleSearchPage.class);

        p.searchFor("cheese");





    }
}
