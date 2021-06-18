/**
 * purpose : To implement script recording concept in project
 * Author : Samiksha Shende
 * Date : 05/06/2021
 */

package com.bridgelabz.selenium.test.atutestrecorder;

import com.bridgelabz.selenium.base.Base;
import com.bridgelabz.selenium.pages.Search;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class ScriptRecordingTest extends Base {
public static Search search;

static org.apache.log4j.Logger log = Logger.getLogger(ScriptRecordingTest.class.getName());

@Test(priority = 1)
public void test_Application(){
        search = new Search(driver);
        search.searchItem();
        log.info("This is log message for test case : search_Item");
    }
}
