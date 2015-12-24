package com.ilrd.pages.teamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 24/12/15.
 */
public class TWAddTaskList extends BaseTWPage{


    @FindBy(id = "newTaskListName")
    private WebElement newTaskListNameBox;

    @FindBy(xpath = "//div[@id='newTaskListFormFooter']/p/input")
    private WebElement newTaskListButton;

    public TWAddTaskList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public TWAddTaskList typeTaskListName(String text){

        newTaskListNameBox.sendKeys(text);

        return this;

    }

    public TWTasksPage addTaskList(){

        newTaskListButton.click();

        return new TWTasksPage(driver);

    }
}
