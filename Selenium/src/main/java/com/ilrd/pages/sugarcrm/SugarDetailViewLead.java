package com.ilrd.pages.sugarcrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 22/12/15.
 */
public class SugarDetailViewLead extends BaseSugarPage{


    public SugarDetailViewLead(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
