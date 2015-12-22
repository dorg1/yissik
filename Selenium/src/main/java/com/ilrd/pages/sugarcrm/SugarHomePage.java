package com.ilrd.pages.sugarcrm;

import com.ilrd.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 22/12/15.
 */
public class SugarHomePage extends BaseSugarPage {

    public SugarHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //TODO check if it actually homePage
    }

}
