package com.testing.utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Listener implements ITestListener {

    private final static Logger LOGGER = Logger.getLogger(Logger.class);
    private ByteArrayOutputStream request = new ByteArrayOutputStream();
    private ByteArrayOutputStream response = new ByteArrayOutputStream();
    private PrintStream requestVar = new PrintStream(request, true);
    private PrintStream responseVar = new PrintStream(response, true);

    public void onStart(ITestContext iTestContext) {
        LOGGER.info("Testing started");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        logRequest(request);
        logResponse(response);
        LOGGER.info("Test: " + iTestResult.getName() + " ended successfully");
    }

    public void onTestFailure(ITestResult iTestResult) {
        onTestSuccess(iTestResult);
        LOGGER.info("Test: " + iTestResult.getName() + " FAILED!");
    }

    //@Attachment(value = "request")
    public byte[] logRequest(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    //@Attachment(value = "response")
    public byte[] logResponse(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    public byte[] attach(ByteArrayOutputStream log) {
        byte[] array = log.toByteArray();
        log.reset();
        return array;
    }

    public void onTestStart(ITestResult iTestResult) {
        RestAssured.filters(new ResponseLoggingFilter(LogDetail.ALL, responseVar),
                new RequestLoggingFilter(LogDetail.ALL, requestVar));
        LOGGER.info("Test: " + iTestResult.getName() + " started!");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("Test: " + iTestResult.getName() + " SKIPPED!");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("Testing finished!");
    }
}
