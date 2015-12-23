package com.ilrd.test;

import com.ilrd.pages.teamwork.TWLoginPage;
import org.testng.annotations.Test;

/**
 * Created by student on 23/12/15.
 */
public class TeamWorkTest extends BaseTest{


    private static final String USER = "fake01@fake.com";
    private static final String PASSWORD = "fake";


    public TeamWorkTest() {
        super("https://topq.teamwork.com");
    }

    @Test
    public void testTWLogin() {

        TWLoginPage p = new TWLoginPage(driver);

        p.loginAs(USER, PASSWORD).getNavigation().tasks();
    }


}
