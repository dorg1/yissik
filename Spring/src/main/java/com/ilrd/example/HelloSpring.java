package com.ilrd.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by soda on 27/12/15.
 */
@Component
@Configuration
@PropertySource("classpath:context.properties")
public class HelloSpring {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Value( "${hello.world}" )
    private String message;

    HelloSpring(){

        System.out.println(message);

    }

    public void postConstruct(){

    }

}
