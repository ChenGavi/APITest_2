package com.automation.APITestFramework.testCase;

import com.automation.APITestFramework.APIs.CreateCustomerAPI;
import com.automation.APITestFramework.utilities.DataUtil;
import io.restassured.response.Response;
import com.automation.APITestFramework.setUp.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import static io.restassured.RestAssured.*;

public class CreateCustomerTest extends BaseTest{

    protected Logger logger = LogManager.getLogger(this.getClass());

    @Test(dataProviderClass = DataUtil.class, dataProvider = "data")
    public void validateCreatedCustomerAPI(String name, String email, String description){

        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(name, email,description);

//        Response response = given().auth().basic(config.getProperty("SecretKey"), config.getProperty("password"))
//                .formParam("name", name)
//                .formParam("email", email)
//                .formParam("description", description)
//                .post(baseURI + basePath + config.get("customerAPIEnPoint"));

        response.prettyPrint();
        if(response.statusCode() == 200){
            logger.info("Successfully create new user");
        }else{
            logger.error("The network status is not good");
        }

    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "data")
    public void invalidateCreatedCustomerAPI(String name, String email, String description){

        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInvalidAuthKey(name, email, description);

//        Response response = given().auth().basic(config.getProperty("InvalidKey"), config.getProperty("password"))
//                .formParam("name", name)
//                .formParam("email", email)
//                .formParam("description", description)
//                .post(baseURI + basePath + config.get("customerAPIEnPoint"));

        response.prettyPrint();
        System.out.println(response.getStatusCode());
        if(response.statusCode() == 401){
            logger.info("Invalid key works");
        }else{
            logger.error("The invalid Key can invade the system");
            Assert.fail("The invalid Key can invade the system");
        }

    }
}
