package com.ilrd;

import org.testng.*;

/**
 * Created by student on 21/12/15.
 */
public class TestListenerImpl implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + " onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + " onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + " onTestFailure");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
