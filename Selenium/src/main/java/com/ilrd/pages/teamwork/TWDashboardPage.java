package com.ilrd.pages.teamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 23/12/15.
 */
public class TWDashboardPage extends BaseTWPage {

    private TWDashboardMenu menu;

    public TWDashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        menu = new TWDashboardMenu(driver);

    }

    public TWDashboardMenu getMenu() {
        return menu;
    }
}
