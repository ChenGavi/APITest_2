package com.automation.APITestFramework.utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TestParameterization {


    @Test(dataProvider = "getData")
    public void testData(String runmode, String firstname, String lastname){

        System.out.println(runmode + "-" + firstname +"--------" + lastname);

    }

    @DataProvider
    public Object[][] getData(){
        ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
        int rows = excel.getRowCount("validateCreatedCustomerAPI");

        System.out.println("Total rows are: " + rows);

        String testName = "validateCreatedCustomerAPI";

        int testCaseRowNum = 1;

        for(testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++){
            String testCaseName = excel.getCellData("validateCreatedCustomerAPI", 0, testCaseRowNum);

            if(testCaseName.equalsIgnoreCase(testName))
                break;
        }

        System.out.println("Test Cases starts from row num: " + testCaseRowNum);

        // Checking total rows in test case
        int dataStartRowNum = testCaseRowNum + 1;
        int testRows = 0;
        while(!excel.getCellData("validateCreatedCustomerAPI", 0, dataStartRowNum + testRows).equals("")){
            testRows++;
        }

        System.out.println("Total rows of data are: " + testRows);


        // Checking total cols in test case
        int colStarColNum = testCaseRowNum + 1;
        int testCols = 0;
        while(!excel.getCellData("validateCreatedCustomerAPI", testCols, colStarColNum).equals("")){
            testCols++;
        }

        System.out.println("Total cols are: " + testCols);

        // Print Data
        Object [][] data = new Object[testRows][1];
        int i = 0;

        for(int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++){
            Hashtable<String, String> table = new Hashtable<String, String>();

            for(int cNum = 0; cNum < testCols; cNum++){

                String testData = excel.getCellData("validateCreatedCustomerAPI", cNum, rNum);
                String colName = excel.getCellData("validateCreatedCustomerAPI", cNum, colStarColNum);
                data[rNum - dataStartRowNum][cNum] = testData;

//                table.put(colName, testData);
            }
//            data[i][0] = table;
//            i++;

        }
        return data;

    }


}
