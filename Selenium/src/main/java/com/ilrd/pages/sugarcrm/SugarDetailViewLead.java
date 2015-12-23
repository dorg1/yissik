package com.ilrd.pages.sugarcrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 22/12/15.
 */
public class SugarDetailViewLead extends BaseSugarPage{


    @FindBy(id = "edit_button")
    WebElement editButton;

    public SugarDetailViewLead(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public SugarEditLead editLead(){

        editButton.click();
        return new SugarEditLead(driver);

    }

}
