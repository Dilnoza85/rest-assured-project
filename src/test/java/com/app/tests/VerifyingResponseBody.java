package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.commons.lang3.Range.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class VerifyingResponseBody {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="application/json;charset=utf-8";

    }
    @Test
    public void testBody(){
        given().when().get().
                //body("name"-->first param is locator gets the value from the response.it will be actual value
                        //second argument will be the matcher
                then().assertThat().body("name",notNullValue());
    }
    @Test
    public void verifyRegion(){
        String region = "Mexico";
        // where only want to get people name from Mexico
        given().
                queryParam("region", region).
                when().get().
                then().log().body().
                assertThat();
    }


    @Test
    public void verifyNumberOfResults(){
        given().
                queryParam("amount", 2).
                when().get().
                then().
                assertThat().body("$", hasSize(2));
        // in this example we are verify number of objects in a json response
    }

}




