package com.ilrd.seleniumutils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * sets system property before webDriver initialization to be able to use ChromeWebDriver
 */



@Component
public class BeforeWebDriver {

    @Value(value = "${chrome.driver.location}")
    String chromeDriverLocation;


    @PostConstruct
    public void init(){

        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

    }
}
