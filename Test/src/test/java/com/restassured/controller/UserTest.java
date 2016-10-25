package com.restassured.controller;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class UserTest {

	
	@BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
//        if(basePath==null){
//            basePath = "/rest-garage-sample/";
//        }
        RestAssured.basePath = "";

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }
	
	@Test
    public void test() {
		Response response = given().contentType("json").when().get("/user" + "?id=1001").then().statusCode(200).extract().response();
		System.out.println(response.path("name"));
    }
}
