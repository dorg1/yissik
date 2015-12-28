package com.ilrd.test;

import com.ilrd.seleniumutils.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 23/12/15.
 */
@Test
@ContextConfiguration(locations = "classpath:seleniumContext.xml")
public class BaseTest {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected Setup setup;


    @BeforeMethod
    public void setupDriver(){

        driver.get(setup.getUrl());
    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
