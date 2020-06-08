package com.automation.APITestFramework.testCase;

import com.automation.APITestFramework.APIs.deleteCustomerAPIWithValidID;
import com.automation.APITestFramework.listeners.ExtentListeners;
import com.automation.APITestFramework.setUp.BaseTest;
import com.automation.APITestFramework.utilities.DataUtil;
import com.automation.APITestFramework.utilities.TestUtil;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteCustomerTest extends BaseTest{

    protected Logger logger = LogManager.getLogger(this.getClass());

    @Test(dataProviderClass = DataUtil.class, dataProvider = "data")
    public void delete_customer(String id){

        Response response = deleteCustomerAPIWithValidID.sendDeleteRequestToDeleteCustomerAPIWithValidAuthKey(id);

        response.prettyPrint();
//        ExtentListeners.testReport.get().info(id);

        System.out.println(response.getStatusCode());

        System.out.println("Present check for the object key: " + TestUtil.jsonHasKey(response.asString(), "object"));
        System.out.println("Present check for the deleted key: " + TestUtil.jsonHasKey(response.asString(), "deleted"));
//        System.out.println(TestUtil.getJsonKeyValue(response.asString(), "deleted"));
        Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"), "ID key is not present in JSON response");

        String actual_id  = TestUtil.getJsonKeyValue(response.asString(), "id");
        System.out.println(actual_id);
        Assert.assertEquals(actual_id, id, "ID not matching");

        System.out.println("Object key value is : " +  TestUtil.getJsonKeyValue(response.asString(), "object"));
        System.out.println("deleted key value is : " +  TestUtil.getJsonKeyValue(response.asString(), "deleted"));



/*
        JSONObject jsonObject = new JSONObject(response.asString());
        System.out.println(jsonObject.has("id"));

        Assert.assertTrue(jsonObject.has("id"), "ID key is not present in list");


 */




//        String actual_id = response.jsonPath().get("id").toString();
//        System.out.println("Getting id from JSON Path: " + actual_id);
//        Assert.assertEquals(actual_id, id, "ID not matching");

//        if(response.statusCode() == 200){
//            logger.info("Successfully delete  new user");
//        }else if(response.statusCode() == 404){
//            logger.error("The customer is not in list");
//            Assert.fail("The customer is not in list");
//        }

    }

}
