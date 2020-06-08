package com.automation.APITestFramework.setUp;

import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.automation.APITestFramework.utilities.ExcelReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static Properties config = new Properties();
    private FileInputStream configFile;
    protected Logger logger = LogManager.getLogger(this.getClass());
    public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");

    @BeforeSuite
    public void setUp() throws IOException {

        try{
            configFile = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
        }catch (FileNotFoundException e){
            logger.error("did not find config file");
            e.printStackTrace();
        }

        try{
            config.load(configFile);
        }catch(IOException e){
            logger.debug("IOException");
            e.printStackTrace();
        }

        RestAssured.baseURI = config.getProperty("baseURI");
        RestAssured.basePath = config.getProperty("basePath");
        logger.info("**************The test suite starts**************");
    }

    @AfterSuite
    public void tearDown(){

        logger.info("*************The test suite finished**************");

    }



}
