package com.ilrd.test;

import com.ilrd.example.HelloSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 28/12/15.
 */
@Test
@ContextConfiguration(locations = "classpath:exampleContext.xml")
public class TestSpring extends AbstractTestNGSpringContextTests {


    @Value(value = "${hello.world.message}")
    String message;

    @Autowired
    HelloSpring helloSpring;

    @Test
    public void testHelloSpring(){


        String a = helloSpring.getMessage();

        System.out.println(a);
        System.out.println(message);


        Assert.assertEquals(a,message);
    }

}
