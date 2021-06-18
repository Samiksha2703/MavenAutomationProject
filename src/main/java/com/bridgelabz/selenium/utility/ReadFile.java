/**
 * purpose : To read exel file
 * Author : Samiksha Shende
 * Date : 05/06/2021
 */

package com.bridgelabz.selenium.utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadFile {
    XSSFWorkbook work_book;
    XSSFSheet sheet;

    public ReadFile(String excelFilePath) {
        try {
            File s = new File(excelFilePath);
            FileInputStream stream = new FileInputStream(s);
            work_book = new XSSFWorkbook(stream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getData(int sheetnumber, int row, int column) {
        sheet = work_book.getSheetAt(sheetnumber);
        String data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;
    }

    public int getRowCount(int sheetIndex) {
        int row = work_book.getSheetAt(sheetIndex).getLastRowNum();
        row = row + 1;
        return row;
    }
}
