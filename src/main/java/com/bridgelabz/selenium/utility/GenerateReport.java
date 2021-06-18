/**
 * purpose : To generate excel report
 * Author : Samiksha Shende
 * Date : 05/06/21020
 */

package com.bridgelabz.selenium.utility;

import org.automationtesting.excelreport.Xl;

public class GenerateReport {

    //method to generate excel report
         public static void generateExcelReport() throws Exception {
            Xl.generateReport("ExcelReportFile.xlsx");
        }
}
