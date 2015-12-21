package org.openqa.selenium.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by soda on 21/12/15.
 */
public class GoogleSearchPage {

    @FindBy(name = "q")
    private WebElement searchBox;

    public GoogleSearchPage searchFor(String text){

        searchBox.sendKeys(text);
        searchBox.submit();
        return this;

    }


}
