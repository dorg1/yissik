package com.ilrd;

/**
 * Created by student on 21/12/15.
 */
public class Calculator {

    private double res;


    public Calculator add(double a, double b) {

        res = a + b;
        return this;

    }

    public double result() {
        return res;
    }

    public Calculator add(double a) {
        res += a;
        return this;
    }

    public Calculator sub(double a, double b) {
        res = a - b;
        return this;

    }

    public Calculator sub(double a) {
        res -= a;
        return this;
    }
}
