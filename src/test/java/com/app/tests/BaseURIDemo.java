package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BaseURIDemo {
    @BeforeClass
    public static void setUpClass(){
    RestAssured.baseURI="https://api.got.show/api";
}
    @Test
    public void culturesTest(){
        //baseURI-->used to save base url for all resources
        //when we actually make reqests,we only provide the path
        //specific resource
        RestAssured.baseURI="https://api.got.show/api";
        Response responce=RestAssured.get("/cultures/");
        responce.prettyPrint();
        Assert.assertTrue(responce.asString().contains("Crannogmen"));
    }
    @Test
    public void citiesTest(){
        RestAssured.baseURI="https://api.got.show/api";
        Response responce=RestAssured.get("/cities/");
        responce.prettyPrint();
        Assert.assertTrue(responce.asString().contains("White Harbor"));
    }

}
