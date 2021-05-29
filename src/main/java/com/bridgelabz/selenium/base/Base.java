package com.bridgelabz.selenium.base;

import com.bridgelabz.selenium.utility.Screenshot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;

    @BeforeTest
    public static void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // launch application
        driver.get("https://www.amazon.in/");
        Screenshot sc = new Screenshot();
        sc.screenshot("HomePage");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
