package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.pages.Search;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;


public class TestCases extends Base {

    static Logger log = Logger.getLogger(TestCases.class.getName());
    public Search search;

    @Test(priority = 1)
    public void search_Item() {
        search = new Search(driver);
        search.searchItem();
        log.info("Test Case : search_Item");
    }
}
