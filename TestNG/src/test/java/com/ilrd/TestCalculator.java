package com.ilrd;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by student on 21/12/15.
 */
//@Listeners({TestListenerImpl.class})
public class TestCalculator {

    private Calculator calc;

    @DataProvider(name = "twoPairsOfDoubles")
    public Object[][] createData() {
        return new Object[][] {
                { 3.4, 2.5 },
                { 6, -1.3},
        };
    }



    @BeforeMethod
    public void Fixture(){

        calc = new Calculator();
    }

   @Test(description = "add two doubles", dataProvider = "twoPairsOfDoubles")
    public void testAdd(double a, double b){

       Reporter.log("data provider:");
       Reporter.log(a + " " + b);

       Assert.assertEquals(calc.add(a,b).result(), a+b);


   }


    @Test(description = "add two doubles and another single", dependsOnMethods = {"testAdd"}, alwaysRun = true)
    public void testAdd2(){

        double a = 3;
        double b = -1;

        Assert.assertEquals(calc.add(a,b).add(2).result(), a+b+2);


    }

    @Test(description = "subtract two doubles")
    public void testSub(){

        double a = 3;
        double b = 1;

        Assert.assertEquals(calc.sub(a,b).result(), a-b);


    }

    @Test(description = "subtract two doubles and another single", dependsOnMethods = {"testSub"}, alwaysRun = true)
    public void testSub2(){

        double a = 3;
        double b = -1;

        Assert.assertEquals(calc.sub(a,b).sub(4).result(), a- b - 4);


    }

}
