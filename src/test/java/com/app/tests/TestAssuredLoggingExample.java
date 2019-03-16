package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;

public class TestAssuredLoggingExample {
    @Test
    public void loggingTest(){
        given().log().all().
                when().get("https://uinames.com/api/");
        System.out.println("****************************************\n");

        //Log Response
        Response response=RestAssured.get("https://uinames.com/api/");
        response.then().log().all();
    }
}
