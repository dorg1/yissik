package com.ilrd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 22/12/15.
 */
public abstract class BasePage {

    public final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }



}
