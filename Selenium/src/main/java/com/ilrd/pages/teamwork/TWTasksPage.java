package com.ilrd.pages.teamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 23/12/15.
 */
public class TWTasksPage extends TWDashboardPage{

    @FindBy(xpath = "//li[@id='liBFOATL']/button")
    private WebElement addTaskList;

    private String taskListName;
    private String taskListId;

    private WebElement taskList;




    public TWTasksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public TWAddTaskList addTaskList(){

        addTaskList.click();

        return new TWAddTaskList(driver);
    }

    public TWTasksPage selectTaskListToHandle(String taskListName){

        this.taskListName = taskListName;
        taskList = driver.findElement(By.xpath("//a[text()='" + taskListName + "']//../.."));

        String href = driver.findElement(By.xpath("//a[text()='" + taskListName + "']")).getAttribute("href");
        String[] temp = href.split("/",20);
        taskListId = temp[temp.length-1];

        return this;
    }



    public TWTasksPage clickAddNewTask(){

        taskList.findElement(By.xpath("div//button")).click();
        return this;


    }

    public TWTasksPage typeNewTaskName(String taskName) {

        taskList.findElement(By.xpath("div//input[@class='tt-query']")).sendKeys(taskName);
        return this;
    }

    public TWTasksPage assignTaskTo(String name) {

        taskList.findElement(By.xpath("div//select[@name='taskAssignedToUserId']//*[text()='" + name + "']")).click();
        return this;
    }

    public TWTasksPage saveTask() {


        taskList.findElement(By.xpath("div//input[@type='submit']")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        return this;

    }

    public List<String> getTasksFromTask(){

        List<String> ret = new ArrayList<>();

        List<WebElement> tasks = taskList.findElements(By.xpath("div//span[@class='taskName']"));

        for(WebElement iter : tasks){
            ret.add(iter.getText());
        }

        return ret;



    }

    public TWTasksPage deleteTaskList() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        taskList.findElement(By.xpath("h3//a[@class='btnDrpDwn tipped']")).click();

        driver.findElement(By.xpath("//a[contains(@href,'"+ taskListId + "') and text()='Delete']")).click();


        return this;
    }
}

