package com.ilrd.pages.teamwork;

import com.ilrd.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 24/12/15.
 */
public class TWAddNewMilestonePage extends BasePage {

    @FindBy(id= "boxContents1")
    WebElement form;

    @FindBy(id= "milestoneName")
    WebElement milestoneName;

    @FindBy(xpath= "//div[@class='formFooter']//input[@type='submit']")
    WebElement saveMilestoneButton;



    public TWAddNewMilestonePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TWAddNewMilestonePage typeName(String name){

        milestoneName.sendKeys(name);

        return this;
    }


    public TWMilestonesPage saveNewMilestone(){
        saveMilestoneButton.click();

        return new TWMilestonesPage(driver);

    }



}
