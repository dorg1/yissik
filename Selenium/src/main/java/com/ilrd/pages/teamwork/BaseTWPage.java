package com.ilrd.pages.teamwork;

import com.ilrd.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by student on 23/12/15.
 */
public abstract class BaseTWPage extends BasePage {


    public BaseTWPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);


    }


}
