package com.ilrd.seleniumutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * Created by student on 28/12/15.
 */
@Component
public class WebDriverFactory {


    @Value(value = "${driver.implicit.wait.time}")
    int implicitTimeWait;

    @Autowired
    WebDriver webDriver;


    @PostConstruct
    public void init(){

        webDriver.manage().timeouts().implicitlyWait(implicitTimeWait, TimeUnit.SECONDS);


    }
}
