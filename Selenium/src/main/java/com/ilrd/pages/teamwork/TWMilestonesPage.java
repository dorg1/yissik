package com.ilrd.pages.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by student on 24/12/15.
 */
public class TWMilestonesPage extends TWDashboardPage {


    @FindBy(xpath = "//button[text()='Add a Milestone']")
    WebElement addMilestone;

    private String milestoneName;
    private String milestoneId;

    private WebElement milestone;

    public TWMilestonesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public TWAddNewMilestoneForm clickAddNewMilestone(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        addMilestone.click();
        return new TWAddNewMilestoneForm(driver);

    }

    public TWMilestonesPage selectMilestoneToHandle(String milestoneName){

        this.milestoneName = milestoneName;
        milestone = driver.findElement(By.xpath("//a[text()='" + milestoneName + "']//../.."));

        String href = driver.findElement(By.xpath("//a[text()='" + milestoneName + "']")).getAttribute("href");
        String[] temp = href.split("/",20);
        milestoneId = temp[temp.length-1];

        System.out.println(milestoneId);

        return this;
    }

    public TWMilestonesPage hoverOnMilestone(){

        Actions  action = new Actions(driver);

        action.moveToElement(milestone).build().perform();

        return this;

    }

    public TWMilestonesPage clickAttachTaskList(){

        Actions  action = new Actions(driver);

        action.moveToElement(milestone).perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        driver.findElement(By.xpath("//a[contains(@onclick,'"+ milestoneId +"' ) and contains(@id, 'attachTaskListBtn')]")).click();

        return this;

    }

    public TWMilestonesPage selectTaskListToAttach(String taskListName){


        Select select = new Select(driver.findElement(By.xpath("//select[@id='"+ "taskListId_" + milestoneId +"' ) ]]")));

        select.selectByValue(taskListName);

        return this;

    }




}
