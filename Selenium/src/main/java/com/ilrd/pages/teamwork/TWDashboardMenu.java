package com.ilrd.pages.teamwork;

import com.ilrd.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 23/12/15.
 */
public class TWDashboardMenu extends BasePage {


    @FindBy(xpath = "//li[@id='tab_tasks']/a")
    private WebElement task;

    @FindBy(xpath = "//li[@id='tab_milestones']/a")
    private WebElement milestones;




    public TWDashboardMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TWTasksPage tasks() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        task.click();
        return new TWTasksPage(driver);
    }

    public TWMilestonesPage milestones() {


        scrollToElement(milestones);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        milestones.click();
        return new TWMilestonesPage(driver);

    }




}
