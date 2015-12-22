package com.ilrd;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by student on 17/12/15.
 */
public class SeleniumAdvanced {

    private static final String URL = "http://localhost/sugar";
    private static String firstName;
    private static String lastName;
    private static final String SALUTATION = "Mr.";
    private static final String SPACE = " ";
    private static WebDriver driver;

    private static void test() throws IOException {

        WebElement webElement;
        System.setProperty("webdriver.chrome.driver", "/home/student/chromedriver");
        driver  = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(URL);


        firstName = "firstName" + System.currentTimeMillis() + "";
        lastName = "lastName" + System.currentTimeMillis() + "";


        //login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("admin");
        driver.findElement(By.id("login_button")).click();


        driver.findElement(By.linkText("Sales")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.xpath("//span[text()='Create Lead']/..")).click();


        driver.findElement(By.id("first_name")).sendKeys(firstName);
        driver.findElement(By.id("last_name")).sendKeys(lastName);

        Select select = new Select(driver.findElement(By.id("salutation")));
        select.selectByValue(SALUTATION);

        if(!driver.findElement(By.id("alt_checkbox")).isSelected()){

            driver.findElement(By.id("alt_checkbox")).click();
        }
        driver.findElement(By.id("SAVE_HEADER")).click();

        driver.findElement(By.linkText("Leads")).click();

        webElement = driver.findElement(By.id("search_name_basic"));
        webElement.clear();
        webElement.sendKeys(lastName);
        webElement.submit();


        driver.findElement(By.linkText("Leads")).click();
        String namePattern = SALUTATION + SPACE + firstName + SPACE + lastName;



        List<WebElement> elements = driver.findElements(By.linkText(namePattern));

        Assert.assertTrue(!elements.isEmpty(), namePattern + "is not in Leads");



    }

    public static void main(String[] args) throws InterruptedException {


        try{

            test();

        }catch(Exception e){
            System.out.println("test failed: " + e.getMessage());
        }

        if(driver != null){
            driver.close();
        }

        System.out.println("test finished");

    }

}
