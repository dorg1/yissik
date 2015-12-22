package com.ilrd.pages.sugarcrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 22/12/15.
 */
public class SugarViewLeads extends BaseSugarPage {
//exercise
    @FindBy(id="search_name_basic")
    WebElement nameSearchBox;

    @FindBy(id="search_form_submit")
    WebElement search;


    public SugarViewLeads(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SugarViewLeads typeName(String name){
        nameSearchBox.clear();
        nameSearchBox.sendKeys(name);
        return this;
    }

    public SugarViewLeads search(){
        search.click();
        return this;
    }



}
