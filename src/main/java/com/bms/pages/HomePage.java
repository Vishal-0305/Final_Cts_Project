package com.bms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver; // This line is CRITICAL
        PageFactory.initElements(driver, this);
    }

    // Locators
    By locationDropdown = By.id("location-dropdown");
    By movieNames = By.className("movie-name");
    public By movieLangs = By.className("movie-lang");
    By sportsLink = By.linkText("Sports");
    By searchSports = By.id("search-sports");
    By eventCount = By.id("event-count");
    public By weekendFilterBtn = By.xpath("//button[text()='This Weekend']");
    public By priceTags = By.className("sport-price");
    By promoFrame = By.id("promo-frame");



    public void selectLocation(String city) {
        new Select(driver.findElement(locationDropdown)).selectByValue(city.toLowerCase());
    }

    public void goToSports() {
        driver.findElement(sportsLink).click();
    }

    public void searchSport(String name) {
        driver.findElement(searchSports).sendKeys(name);
    }

    public int getVisibleEventCount() {
        return Integer.parseInt(driver.findElement(eventCount).getText());
    }

    public List<WebElement> getAllMovies() {
        return driver.findElements(movieNames);
    }

    public void switchToPromoFrame() {
        driver.switchTo().frame(driver.findElement(promoFrame));
    }
}