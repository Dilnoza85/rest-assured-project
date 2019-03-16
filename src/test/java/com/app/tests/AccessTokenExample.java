package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.ws.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class AccessTokenExample {
    @BeforeClass
    public static void setUP(){
        RestAssured.baseURI="https://cybertek-reservation-api-qa.herokuapp.com/";

    }
    @Test
    public void getTokenTest(){
        Response response=given()
        given().log().all().
                param("email","teacherva5@gmail.com").
                param("password","maxpayne").
                get("sign");
        response.then().log
                then().log().all().
                assertThat().statusCode(200);

    }
}
