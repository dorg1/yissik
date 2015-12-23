package com.ilrd.pages.sugarcrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by student on 22/12/15.
 */
public class SugarEditLead extends SugarLeadForm{


    public SugarEditLead(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

        //TODO sync with page check this is actually edit lead page
    }



}
