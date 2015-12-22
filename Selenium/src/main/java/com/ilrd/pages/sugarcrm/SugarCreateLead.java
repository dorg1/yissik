package com.ilrd.pages.sugarcrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by student on 22/12/15.
 */
public class SugarCreateLead extends BaseSugarPage{


    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "salutation")
    WebElement salutation;

    @FindBy(id = "alt_checkbox")
    WebElement copyAddressFromLeftCheckbox;

    @FindBy(id = "SAVE_HEADER")
    WebElement saveLead;



    public SugarCreateLead(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public SugarCreateLead typeFirstName(String firstName) {

        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        return this;
    }

    public SugarCreateLead typeLastName(String lastName) {

        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        return this;
    }

    public SugarCreateLead selectSalutation(String salutation) {

        Select select = new Select(this.salutation);
        select.selectByValue(salutation);

        return this;

    }

    public SugarCreateLead copyAddressFromLeftCheckbox(boolean on) {


        if(!this.copyAddressFromLeftCheckbox.isSelected() && on){

            copyAddressFromLeftCheckbox.click();
        }

        return this;

    }

    public SugarDetailViewLead saveLead() {

        saveLead.click();
        return new SugarDetailViewLead(driver);

    }



}
