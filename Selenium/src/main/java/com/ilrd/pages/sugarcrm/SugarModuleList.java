package com.ilrd.pages.sugarcrm;

import com.ilrd.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 22/12/15.
 */
public class SugarModuleList extends BasePage{

    @FindBy(id = "grouptab_0")
    WebElement sales;

    SugarSubModuleList sugarSubModuleList;

    public SugarModuleList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        sugarSubModuleList = new SugarSubModuleList(driver);
    }


    public SugarSubModuleList sales() {

        sales.click();
        return sugarSubModuleList;

    }
}
