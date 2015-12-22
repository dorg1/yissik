package com.ilrd.test;

import com.ilrd.pages.sugarcrm.SugarLeads;
import com.ilrd.pages.sugarcrm.SugarLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 22/12/15.
 */
public class SugarTest {

    private WebDriver driver;
    private String firstName;
    private String lastName;
    private String salutation = "Prof.";



    @BeforeMethod
    public void fixture(){

        //TODO parametrize
        System.setProperty("webdriver.chrome.driver", "/home/student/chromedriver");
        driver  = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://localhost/sugar");
        firstName = "firstName" + System.currentTimeMillis();
        lastName = "lastName" + System.currentTimeMillis();

    }


    @AfterMethod
    public void tearDown(){
//        driver.close();
    }

    @Test(description = "SugarCRM: login and create lead")
    @Parameters({"userName", "password"})
    public void test(String userName, String password) {

        SugarLogin p = new SugarLogin(driver);

        p.loginAs(userName, password).getNavigation().sales().leads().createLead().
                typeFirstName(firstName)
                .typeLastName(lastName).
                selectSalutation(salutation)
                .copyAddressFromLeftCheckbox(true).saveLead().
                getNavigation().sales()
                .leads().viewLeads().typeName(lastName).search();

    }


}
