package org.openqa.selenium.example;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by student on 16/12/15.
 */
public class SeleniumEx {

    //private WebElement getElement

    static Boolean pass = false;
    private static final String url = "http://localhost:8081";
    private static final String username = "username";
    private static final String firstName = "firstName";
    private static final String lastName = "lastName";
    private static final String password = "password";

    private static WebDriver driver = new FirefoxDriver();
    private static WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

    private static void test(){

        WebElement webElement;
        driver.get(url);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#/register']"))).click();


        //register
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("Text1")).sendKeys(lastName);
        driver.findElement(By.id("username")).sendKeys(username);
        webElement = driver.findElement(By.id("password"));
        webElement.sendKeys(password);
        webElement.submit();

        //assert registration
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-success")));
            driver.findElement(By.className("alert-success"));
        }
        catch(ElementNotFoundException e){
            //handle exception
            System.out.println("registration failed. exception: " + e.getMessage());
            return;
        }



        //login
        driver.findElement(By.id("username")).sendKeys(username);
        webElement = driver.findElement(By.id("password"));
        webElement.sendKeys(password);
        webElement.submit();

        //assert login
        System.out.println(" " + driver.getCurrentUrl());
        boolean isLoggedIn = webDriverWait.until(ExpectedConditions.urlToBe(url + "/#/"));

        Assert.assertTrue(isLoggedIn, "login unsuccessful. ");



        //delete user
        String userPattern = username + " (" + firstName + " " + lastName + ")";
        driver.findElement(By.xpath("//li[contains(//li/text(),'"+ userPattern + "')]//a[@href='#']")).click();

        //logout
        driver.findElement(By.xpath("//a[@href='#/login']")).click();
        pass = true;

    }

    public static void main(String[] args) throws InterruptedException {


        try{

            test();

        }catch(Exception e){
            pass = false;
            System.out.println("test failed: " + e.getMessage());
        }

        System.out.println("test finished pass = " + pass);
        driver.close();


    }


}
