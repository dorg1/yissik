package com.ilrd.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 20/12/15.
 */

public class TestNGSimpleTest {
    @Test
    public void testAdd() {
        String str = "TestNG is working fine";
        Assert.assertEquals("TestNG is working fine", str);
    }
}


