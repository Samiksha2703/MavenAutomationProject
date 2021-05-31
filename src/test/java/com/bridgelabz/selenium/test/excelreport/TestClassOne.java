package com.bridgelabz.selenium.test.excelreport;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.pages.Login;
import com.bridgelabz.selenium.pages.Logout;
import com.bridgelabz.selenium.pages.Search;
import com.bridgelabz.selenium.test.TestCases;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestClassOne extends Base {
    static Logger log = Logger.getLogger(TestCases.class.getName());
    public Search search;
    public Login login;
    public Logout logout;

    @Test(priority = 1)
    public void search_Item() {
        search = new Search(driver);
        search.searchItem();
        log.info("This is log message for test case : search_Item");
    }

    //Method to test the login feature functionality
    @Test(priority = 2)
    public void amazon_Login() throws InterruptedException {
        login = new Login(driver);
        login.loggedInToApp("shende.samiksha@rediffmail.com", "Welcome@01");
        log.info("This is log message for test case : login into account");
    }

    //Method to test the functionality of the SignOut feature
    @Test(priority = 3)
    public void select_Logout() {
        logout = new Logout(driver);
        logout.signOut_From_Account();
        log.info("This is log message for test case : logout from account");
    }
}
