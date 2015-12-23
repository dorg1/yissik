package com.ilrd.pages.sugarcrm;

import com.ilrd.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.internal.Streams;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 22/12/15.
 */
public class SugarSubModuleList extends BasePage{


    @FindBy(linkText = "Leads")
    WebElement leads;


    public SugarSubModuleList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SugarLeads leads(){
        leads.click();
        return new SugarLeads(driver);
    }




}
