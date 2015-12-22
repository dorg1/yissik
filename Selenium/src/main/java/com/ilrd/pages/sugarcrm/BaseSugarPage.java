package com.ilrd.pages.sugarcrm;

import com.ilrd.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 22/12/15.
 */
public abstract class BaseSugarPage extends BasePage {

    SugarNavigation navigation;

    public SugarNavigation getNavigation() {
        return navigation;
    }

    public BaseSugarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        navigation = new SugarNavigation(driver);

    }



}
