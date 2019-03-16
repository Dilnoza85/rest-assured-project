package com.app.tests;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HomeWork {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://api.github.com";
    }
    @Test
    public void userTest(){
        given().pathParam("username","marufjont").
                when().get("/users/{username}").
                prettyPrint();
    }

}
