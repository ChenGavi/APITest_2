package com.automation.APITestFramework.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class MyExcelReader {

    private static final String FILE_NAME = ".\\src\\test\\resources\\excel\\testdata.xlsx";


    public static void main(String[] args) {
        try{
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);

            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while(iterator.hasNext()){
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()){
                    Cell currentCell = cellIterator.next();

                    if(currentCell.getCellTypeEnum() == CellType.STRING){
                        System.out.println(currentCell.getStringCellValue() + "------");
                    }else if(currentCell.getCellTypeEnum() == CellType.NUMERIC){
                        System.out.println(currentCell.getNumericCellValue() + "--");
                    }
                }

                System.out.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
