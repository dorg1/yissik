package com.ilrd.test;

import com.ilrd.pages.BasePage;
import com.ilrd.pages.sugarcrm.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * Created by student on 22/12/15.
 */
public class SugarTest extends BaseTest{

    private String firstName;
    private String lastName;
    private String salutation = "Prof.";


    @BeforeMethod
    public void fixture(){

        firstName = "firstName" + System.currentTimeMillis();
        lastName = "lastName" + System.currentTimeMillis();

    }


    @Test(description = "SugarCRM: login and create lead")
    @Parameters({"userName", "password"})
    public void createLead(String userName, String password) {

        BaseSugarPage p = login(userName, password);

        p = createLead(p, firstName, lastName, salutation, true);

        p = searchForLead(p, lastName);

        String fullName = salutation + " " + firstName + " " + lastName;
        Assert.assertTrue(p.isElementExist(By.linkText(fullName)), fullName + " not found" );

    }



    @Test(description = "SugarCRM: login, create and edit lead", dependsOnMethods = "createLead")
    @Parameters({"userName", "password"})
    public void editLead(String userName, String password) {


        BaseSugarPage p = login(userName, password);

        p = createLead(p, firstName, lastName, salutation, true);

        p = searchForLead(p, lastName);


        String fullName = salutation + " " + firstName + " " + lastName;
        Assert.assertTrue(p.isElementExist(By.linkText(fullName)), fullName + " not found");


        editLead(p, fullName, firstName + "xyz", lastName + "xyz", "Mr.", false);

        p = searchForLead(p, lastName + "xyz");

        String newFullName = "Mr." + " " + firstName + "xyz " + lastName + "xyz";

        Assert.assertTrue(p.isElementExist(By.linkText(newFullName)), fullName + " not found" );

    }




    @Test(description = "SugarCRM: negative login")
    @Parameters({"userName", "password"})
    public void negativeLogin(String userName, String password) {

        SugarLogin p = new SugarLogin(driver);

        BasePage page = p.loginAsExpectingError(userName + "123", password);

        Assert.assertTrue(page.isElementExist(By.id("login_button")),  "not in login page" );


    }



    public BaseSugarPage login(String userName, String password){

        SugarLogin p = new SugarLogin(driver);
        return p.loginAs(userName, password);

    }

    public BaseSugarPage createLead(BaseSugarPage p, String first, String last, String salutation, boolean copyAddressFromLeftCheckbox){

        return p.getNavigation().sales().leads().createLead().
                typeFirstName(first)
                .typeLastName(last).
                        selectSalutation(salutation)
                .copyAddressFromLeftCheckbox(copyAddressFromLeftCheckbox).saveLead();
    }

    public BaseSugarPage searchForLead(BaseSugarPage p, String text){

        return p.getNavigation().sales().leads().viewLeads().typeName(text).search();

    }

    public BaseSugarPage editLead(BaseSugarPage p, String oldFullName, String first, String last, String salutation, boolean copyAddressFromLeftCheckbox) {

        SugarViewLeads page = (SugarViewLeads) p;

        return page.clickOnName(oldFullName).editLead().typeFirstName(first).typeLastName(last).
                selectSalutation(salutation).copyAddressFromLeftCheckbox(copyAddressFromLeftCheckbox).saveLead();


    }



}
