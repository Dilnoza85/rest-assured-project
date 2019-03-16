package com.app.tests;

import io.restassured.RestAssured;
import org.junit.Test;

public class AuthenticationExample {
    @Test
    public void usingApiKey() {
        RestAssured.given().log().all().
                queryParam("t", "Scorpion").
                queryParam("apikey", "4f1faf24").
                when().get("http://www.omdbapi.com/").
                then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void basicAuthentication401Validation() {
        //https://the -internet.herokuapp.com/basic_auth
        //when we try to hit and endpoint without being authorised
        //we can 401 not authorised error
        RestAssured.get("https://the-internet.herokuapp.com/basic_auth").
                then().assertThat().statusCode(401);
    }

    @Test
    public void basicAuthentication() {
        //auth-->provides different types of authentication
        //based-->authentication using username and password
        RestAssured.given().
                auth().basic("admin", "admin").
                when().get("https://the-internet.herokuapp.com/basic_auth").
                then().assertThat().statusCode(200);
    }

    @Test
    public void xmlResponceExample() {
        //this is not an authorization example
    RestAssured.get("http://parabank.parasoft.com/parabank/services/bank/customers/12212").
            then().log().all().assertThat().statusCode(200);
    }
    @Test
    public void basicPreemtiveAuthentication(){
        RestAssured.given().auth().preemptive().
                basic("admin","admin").when().
                get("https://the-internet.herokuapp.com/basic_auth").
                then().assertThat().statusCode(200);
    }
}