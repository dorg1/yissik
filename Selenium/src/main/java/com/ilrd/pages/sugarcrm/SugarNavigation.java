package com.ilrd.pages.sugarcrm;

import com.ilrd.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 22/12/15.
 */
public class SugarNavigation extends BasePage {


    SugarModuleList sugarModuleList;


    public SugarNavigation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        sugarModuleList = new SugarModuleList(driver);
    }

    public SugarSubModuleList sales(){

        return sugarModuleList.sales();
    }


}
