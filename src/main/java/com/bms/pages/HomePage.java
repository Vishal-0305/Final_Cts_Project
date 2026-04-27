package com.bms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    By sportsLink = By.linkText("Sports");
    By moviesLink = By.linkText("Movies");
    By signInLink = By.partialLinkText("Sign");
    By bmsLogo = By.className("logo");
    By searchBar = By.id("main-search");
    By footerText = By.tagName("footer");

    // Actions
    public void goToSports() { driver.findElement(sportsLink).click(); }

    public void goToMovies() { driver.findElement(moviesLink).click(); }

    public void goToSignIn() { driver.findElement(signInLink).click(); }

    public boolean isLogoDisplayed() { return driver.findElement(bmsLogo).isDisplayed(); }

    public void enterSearch(String text) { driver.findElement(searchBar).sendKeys(text); }

    public String getFooterContent() { return driver.findElement(footerText).getText(); }

    public String getPageTitle() { return driver.getTitle(); }
}