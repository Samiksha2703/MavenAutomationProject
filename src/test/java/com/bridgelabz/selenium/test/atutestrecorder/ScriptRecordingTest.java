package com.bridgelabz.selenium.test.atutestrecorder;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.bridgelabz.selenium.pages.Search;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ScriptRecordingTest {
WebDriver driver;
ATUTestRecorder recorder;
Search search;

static org.apache.log4j.Logger log = Logger.getLogger(ScriptRecordingTest.class.getName());

@BeforeTest
    public void setUp() throws ATUTestRecorderException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("https://www.amazon.in/");
    DateFormat dateFormat = new SimpleDateFormat("dd-MM--yyyy HH-mm-ss");
    Date date = new Date();

    //create an object of ScriptRecordingTest class and pass 3 parameters explained above.
    recorder = new ATUTestRecorder("C:\\Users\\kalam\\ScriptRecording","Script_Video_" + dateFormat.format(date), false);

    //To start video recording
    recorder.start();
}

@Test(priority = 1)
public void test_Application(){
        search = new Search(driver);
        search.searchItem();
        log.info("This is log message for test case : search_Item");
    }

    @AfterTest
    public void tearDown() throws ATUTestRecorderException {
        //close browser
        driver.quit();
        //Stop the recording
        recorder.stop();
    }
}
