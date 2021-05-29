package com.bridgelabz.selenium.controller;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.pages.Login;
import com.bridgelabz.selenium.pages.Logout;
import com.bridgelabz.selenium.utility.ReadFile;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven extends Base {
    static Logger log = Logger.getLogger(DataDriven.class.getName());
    public Login login;
    public static Logout logout;
    private static Object[][] sign_in_credentials;

    @Test(dataProvider = "testdata")
    public void data_Driven_Demo_Method(String username, String password) throws InterruptedException {
        login = new Login(driver);
        login.loggedInToApp(username, password);
        logout = new Logout(driver);
        logout.signOut_From_Account();
        driver.get("https://www.amazon.in/");
        log.info("Test Case : data_Driven_Demo_Method");
    }

    @DataProvider(name = "testdata")
    public Object[][] testData() {
        ReadFile readFile = new ReadFile("C:\\Users\\kalam\\IdeaProjects\\MavenAutomationProject\\src\\main\\resources\\TestData.xls");
        int rows = readFile.getRowCount(0);
        sign_in_credentials = new Object[rows][2];
        for (int i = 0; i < rows; i++) {
            sign_in_credentials[i][0] = readFile.getData(0, i, 0);
            sign_in_credentials[i][1] = readFile.getData(0, i, 1);
        }
        return sign_in_credentials;
    }
}
