package com.ilrd.pages.sugarcrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by student on 23/12/15.
 */
public class SugarLeadForm extends BaseSugarPage {

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

    public SugarLeadForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }




    public SugarLeadForm typeFirstName(String firstName) {

        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        return this;
    }

    public SugarLeadForm typeLastName(String lastName) {

        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        return this;
    }

    public SugarLeadForm selectSalutation(String salutation) {

        Select select = new Select(this.salutation);
        select.selectByValue(salutation);

        return this;

    }

    public SugarLeadForm copyAddressFromLeftCheckbox(boolean on) {


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
