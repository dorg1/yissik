package com.ilrd.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by soda on 27/12/15.
 */
@Component
public class HelloSpring {

    public String getMessage() {
        return message;
    }

    @Value(value = "${hello.world}")
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public HelloSpring() {
        System.out.println("HelloSpring ctor");
    }

    public void printMessage() {
        System.out.println( "message: " + message);
    }


}
