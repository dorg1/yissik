package com.ilrd.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 23/12/15.
 */
public class BaseTest {

    protected WebDriver driver;
    protected String URL;

    public BaseTest(String URL) {
        this.URL = URL;
    }

    @BeforeMethod
    public void setupDriver(){
        //System.setProperty("webdriver.chrome.driver", "/home/student/chromedriver");
//        driver  = new ChromeDriver();
        driver  = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
