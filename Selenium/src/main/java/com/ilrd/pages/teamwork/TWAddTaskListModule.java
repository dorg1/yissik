package com.ilrd.pages.teamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 24/12/15.
 */
public class TWAddTaskListModule extends BaseTWPage{


    @FindBy(id = "newTaskListName")
    private WebElement newTaskListNameBox;

    @FindBy(xpath = "//div[@id='newTaskListFormFooter']/p/input")
    private WebElement newTaskListButton;

    public TWAddTaskListModule(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public TWAddTaskListModule typeTaskListName(String text){

        newTaskListNameBox.sendKeys(text);

        return this;

    }

    public TWTasksPage clickOnAddTaskList(){

        newTaskListButton.click();

        return new TWTasksPage(driver);

    }
}
