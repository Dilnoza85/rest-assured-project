package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class QueryParamsExample {
@BeforeClass
    public static void setUp(){
    RestAssured.baseURI="https://uinames.com/api/";
}
@Test
    public void testAmount(){
    given().
            queryParam("amount","3").
            when().get().prettyPrint();
}
@Test
    public void testRegion(){
    given().queryParam("region","Columbia").
            when().get().prettyPrint();
}
@Test
    public void amountAndRegionTest(){
    given().queryParam("amount",2).
            queryParam("region","Colombia").get().prettyPrint();
}


}
