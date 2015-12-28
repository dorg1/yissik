package com.ilrd.seleniumutils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by student on 28/12/15.
 */
@Component
public class Setup {


    @Value( value = "${test.url}")
    private String url;

    @Value( value = "${default.username}")
    private String defaultUser;

    @Value( value = "${default.password}")
    private String defaultPassword;


    public String getDefaultPassword() {
        return defaultPassword;
    }

    public void setDefaultPassword(String defaultPassword) {
        this.defaultPassword = defaultPassword;
    }

    public String getDefaultUser() {
        return defaultUser;
    }

    public void setDefaultUser(String defaultUser) {
        this.defaultUser = defaultUser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
