/**
 * purpose : To implement extent report concept in the project
 * Author : Samiksha Shende
 * Date : 05/06/2021
 */

package com.bridgelabz.selenium.extentreport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExtentReport {
    public static WebDriver driver;
    static ExtentTest test;
    static ExtentReports report;

    @BeforeClass
    public static void startTest() {
        report = new ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
        String filepath = System.getProperty("user.dir") + "ExtentReportResults.html";
        System.out.println("Path = \n" + filepath);
        test = report.startTest("ExtentDemo");
    }

    @Test
    public void extentReportsDemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in");
        if (driver.getTitle().equals("Google")) {
            test.log(LogStatus.PASS, "Navigated to the specified URL");
        } else {
            test.log(LogStatus.FAIL, "Test Failed");
        }
    }

    @AfterClass
    public static void endTest() {
        report.endTest(test);
        report.flush();
        report.close();
        driver.close();
    }
}