package com.ilrd.example;

import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.*;

/**
 * Created by soda on 27/12/15.
 */
public class Main {


    @Autowired
    HelloSpring helloSpring;

    public static void main(String[] args) throws IOException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");

//        HelloSpring helloSpring = (HelloSpring)ctx.getBean("helloSpring");


        System.out.println("goodbye spring");

    }
}
