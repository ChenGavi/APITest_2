package com.automation.APITestFramework.APIs;

import com.automation.APITestFramework.setUp.BaseTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class deleteCustomerAPIWithValidID extends BaseTest {

    public static Response sendDeleteRequestToDeleteCustomerAPIWithValidAuthKey(String id){

        Response response = given().auth().basic(config.getProperty("SecretKey"), config.getProperty("password"))
                .delete(baseURI + basePath + config.getProperty("customerAPIEnPoint") + "/" + id);

        return response;

    }
}
