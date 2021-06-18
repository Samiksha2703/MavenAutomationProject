/**
 * purpose : To create setup to run before and after test cases
 * Author : Samiksha Shende
 * Date : 05/06/2021
 */

package com.bridgelabz.selenium.base;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.bridgelabz.selenium.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.io.IOException;
import java.net.*;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static RecordVideo recordVideo = new RecordVideo();
    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    @BeforeTest
    public static void setup() throws IOException, ATUTestRecorderException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        threadLocal.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try{
            URL url = new URL("https://www.amazon.in/");
            URLConnection connection = url.openConnection();
            connection.connect();
            System.out.println("Internet is connected");
            // launch application
            driver.get("https://www.amazon.in/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Screenshot sc = new Screenshot();
        sc.screenshot("HomePage");
        recordVideo.startRecording();
    }

    @AfterTest
    public void tearDown() throws Exception {
        GenerateReport.generateExcelReport();
        driver.close();
        recordVideo.stopRecording();
    }

    public static WebDriver getDriver() {
        return threadLocal.get();
    }

}
