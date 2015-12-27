package com.ilrd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

/**
 * Created by student on 22/12/15.
 */
public abstract class BasePage {

    protected final WebDriver driver;
    JavascriptExecutor jse;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        jse = (JavascriptExecutor) driver;
    }

    public boolean isElementExist(By by){

        List<WebElement> elements = driver.findElements(by);

        return !elements.isEmpty();

    }

    public BasePage scrollToElement(WebElement element){

        jse.executeScript("arguments[0].scrollIntoView()", element);

        return this;

    }

}
