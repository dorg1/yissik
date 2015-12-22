package com.ilrd.pages.sugarcrm;

import com.ilrd.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by student on 22/12/15.
 */

public class SugarLeads extends BaseSugarPage {


    @FindBy(xpath = "//span[text()='Create Lead']/..")
    WebElement createLead;

    @FindBy(xpath = "//span[text()='View Leads']/..")
    WebElement viewLeads;

    public SugarLeads(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


    public SugarCreateLead createLead(){

            createLead.click();
            return new SugarCreateLead(driver);
    }

    public SugarViewLeads viewLeads(){

        viewLeads.click();
        return new SugarViewLeads(driver);
    }




}
