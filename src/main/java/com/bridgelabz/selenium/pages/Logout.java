/**
 * purpose : To implement logout functionality in project
 * Author : Samiksha Shende
 * Date : 05/06/2021
 */

package com.bridgelabz.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {

    @FindBy(id = "nav-hamburger-menu")
    WebElement menuButton;

    @FindBy(linkText = "Sign Out")
    WebElement signOut;

    public Logout(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Method to sign out from the account
    public void signOut_From_Account() {
        menuButton.click();
        signOut.click();
    }
}
