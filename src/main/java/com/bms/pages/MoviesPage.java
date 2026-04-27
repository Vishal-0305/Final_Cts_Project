package com.bms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MoviesPage {
    WebDriver driver;

    // Locators
    By sectionBarLinks = By.cssSelector(".section-bar a");
    By allMovieCards = By.className("movie-card");
    By recommendedSection = By.id("recommended");
    By upcomingSection = By.id("upcoming");
    By movieNames = By.className("movie-name");
    By topRatedRibbons = By.className("ribbon");

    public MoviesPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public int getTotalMovieCount() {
        return driver.findElements(allMovieCards).size();
    }

    public void clickSectionLink(String sectionName) {
        // Find the link in the section bar that matches the text (Recommended, Premieres, etc.)
        driver.findElement(By.linkText(sectionName)).click();
    }

    public boolean isSectionInViewport(String sectionId) {
        WebElement section = driver.findElement(By.id(sectionId));
        // JS check to see if the element has scrolled into view
        return (Boolean) ((JavascriptExecutor) driver).executeScript(
                "var rect = arguments[0].getBoundingClientRect();" +
                        "return (rect.top >= 0 && rect.bottom <= window.innerHeight);", section);
    }

    public int getRecommendedMovieCount() {
        return driver.findElements(By.cssSelector("#recommended .movie-card")).size();
    }

    public String getFirstMovieTitle() {
        return driver.findElements(movieNames).get(0).getText();
    }

    public boolean hasTopRatedRibbon() {
        return driver.findElement(topRatedRibbons).isDisplayed();
    }
}