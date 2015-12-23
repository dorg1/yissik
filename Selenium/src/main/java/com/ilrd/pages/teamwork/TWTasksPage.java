package com.ilrd.pages.teamwork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 23/12/15.
 */
public class TWTasksPage extends BaseTWPage{

    public TWTasksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
