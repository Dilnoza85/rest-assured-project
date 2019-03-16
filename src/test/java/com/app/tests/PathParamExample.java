package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PathParamExample {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://api.got.show/api/";
    }
    @Test
    public void getCityByNameTest(){
        //statement where we prepare the request
  given().
          //adding param'name' with value'Quarth'
          pathParam("name", "King's Landing").
          //send the request
          when().
          //{name}--> will be replaces by value of the path param
        get("/cities/{name}").prettyPrint();
    }
    @Test
    public void getCharacterByName() {
        given().
                pathParam("name", "Pyp").
                when().
                get("characters/{name}").
                prettyPrint();

    }

    @Test
    public void getCharacterById(){
        given().
                pathParam("id", "56ffc5c00432440819385cfe").
                when().
                get("characters/byId/{id}").prettyPrint();
    }// https://api.got.show/api/characters/byId/:id



}
