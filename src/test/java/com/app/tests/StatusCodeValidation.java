package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StatusCodeValidation {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://uinames.com/api/";
    }
    @Test
    public void testOk(){
        //given-prep request
        given().
                when().get().then().statusCode(200);
        //the submit request
        //then verify response
    }
    @Test
    public void notFoundTest(){
        given().when().get("bsnmdbmnds").
                then().statusCode(404);
    }
}
