/**
 * purpose : To implement search functionality in project
 * Author : Samiksha Shende
 * Date : 05/06/2021
 */

package com.bridgelabz.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement item;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchButton;

    public Search (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchItem() {
        item.sendKeys("boat earphones");
        searchButton.click();
    }
}
