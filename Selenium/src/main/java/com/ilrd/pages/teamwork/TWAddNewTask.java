package com.ilrd.pages.teamwork;

import com.ilrd.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by student on 24/12/15.
 */
public class TWAddNewTask extends BasePage{


    public TWAddNewTask(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }


}
