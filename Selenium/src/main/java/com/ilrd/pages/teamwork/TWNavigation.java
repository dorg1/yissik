package com.ilrd.pages.teamwork;

import com.ilrd.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 23/12/15.
 */
public class TWNavigation extends BasePage {


    //@FindBy(xpath = "//*[@id='tab_tasks']/a")
   // @FindBy(linkText = "Tasks")
    //@FindBy(xpath = "//*[text()='Tasks']")
    //*[text()='Tasks']
    WebElement tasks;

    public TWNavigation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TWTasksPage tasks(){

        int attempts = 0;
        while(attempts < 1) {
            try {
                driver.findElement(By.xpath("//*[text()='Tasks']")).click();

            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }

        System.out.println("attempts: " +attempts);


        //driver.findElement(By.xpath("//*[text()='Tasks']")).click();
        //tasks.click();
        return new TWTasksPage(driver);
    }


}
