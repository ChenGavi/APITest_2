package com.automation.APITestFramework.APIs;

import com.automation.APITestFramework.setUp.BaseTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateCustomerAPI extends BaseTest {

    public static Response sendPostRequestToCreateCustomerAPIWithValidAuthKey(String name, String email, String description){

        Response response = given().auth().basic(config.getProperty("SecretKey"), config.getProperty("password"))
                .formParam("name", name)
                .formParam("email", email)
                .formParam("description", description)
                .post(baseURI + basePath + config.getProperty("customerAPIEnPoint"));

        return response;

    }


    public static Response sendPostRequestToCreateCustomerAPIWithInvalidAuthKey(String name, String email, String description){

        Response response = given().auth().basic(config.getProperty("InvalidKey"), config.getProperty("password"))
                .formParam("name", name)
                .formParam("email", email)
                .formParam("description", description)
                .post(baseURI + basePath + config.getProperty("customerAPIEnPoint"));

        return response;

    }
}
