/**
 * purpose : To implement functionality of search module in project
 * Author : Samiksha Shende
 * Date : 05/06/2021
 */

package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.pages.Search;
import com.bridgelabz.selenium.utility.TestNgListener;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)
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
