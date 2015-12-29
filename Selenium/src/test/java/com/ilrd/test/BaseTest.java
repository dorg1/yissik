package com.ilrd.test;

import com.ilrd.seleniumutils.Setup;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by student on 23/12/15.
 */
@ContextConfiguration(locations = "classpath:seleniumContext.xml")
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

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
