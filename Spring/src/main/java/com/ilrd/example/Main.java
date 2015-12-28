package com.ilrd.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created by soda on 27/12/15.
 */

public class Main {





    public static void main(String[] args) throws IOException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/exampleContext.xml");
        System.out.println("start");
        HelloSpring helloSpring = (HelloSpring)ctx.getBean("helloSpring");
        helloSpring.setMessage("A");
        helloSpring.printMessage();

        HelloSpring helloSpring2 = (HelloSpring)ctx.getBean("helloSpring");
//        helloSpring2.setMessage("B");
        helloSpring2.printMessage();



        System.out.println("end");

    }
}
