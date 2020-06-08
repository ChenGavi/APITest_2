package com.automation.APITestFramework.utilities;

import com.automation.APITestFramework.setUp.BaseTest;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataUtil extends BaseTest {

    @DataProvider(name = "data", parallel = true)
    public Object[][] getData(Method m){

        String sheetName = m.getName(); //sheet name设置成和function name一样
        String testName = m.getName();

        System.out.println("Test Name: " + testName);
        System.out.println("Sheet  Name: " + sheetName);

        int row = excel.getRowCount(sheetName);
        int col = excel.getColumnCount(sheetName);

//        System.out.println("Total rows is " + row + "  Total; col is " + col);
        Object[][] data = new Object[row-1][col];

        System.out.println("cell data " + excel.getCellData(sheetName, 1, 2));

        for(int rowNum = 2; rowNum <= row; rowNum++){
            for(int colNum = 0; colNum < col; colNum++){
                data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
            }
        }

        return data;
    }


}
