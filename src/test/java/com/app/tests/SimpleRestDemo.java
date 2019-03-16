package com.app.tests;


import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.response.Response;
public class SimpleRestDemo {
    @Test
    public void test1(){
        //this is class from rest assured library,it contains methods used for
        //creating and sending requests
        //get method for making a get request,accepts the resource url as parameter
        Response response = RestAssured.get("https://uinames.com/api/");
        response.prettyPrint();

        String resString=response.asString();
        Assert.assertTrue(resString.contains("name"));
        int code=response.statusCode();
        Assert.assertEquals(200,code);


    }
    @Test
    public void test2(){
        Response response=RestAssured.get("https://uinames.com/api/");
        response.prettyPrint();
        String resString=response.asString();
       Assert.assertTrue(resString.contains("g"));

    }

    @Test
    public void headersTest(){
        Response response=RestAssured.get("https://uinames.com/api/");
        System.out.println(response.headers());
        String contentType=response.header("Content-Type");
        System.out.println(contentType);
        Assert.assertEquals("application/json; charset=utf-8",contentType);

    }

    @Test
    public void statusLineTest(){
        Response response=RestAssured.get("https://uinames.com/api/");
        String statusLine=response.statusLine();
        System.out.println(statusLine);
        Assert.assertTrue(statusLine.contains("200"));

    }

}
