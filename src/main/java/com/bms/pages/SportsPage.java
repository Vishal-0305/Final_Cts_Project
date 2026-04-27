package com.bms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SportsPage {
    WebDriver driver;

    // Locators
    By searchBox = By.id("search-sports");
    By eventCount = By.id("event-count");
    By weekendBtn = By.xpath("//button[onclick='filterWeekend()']");
    By clearBtn = By.xpath("//button[text()='Clear All']");

    public SportsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void searchFor(String sportName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(sportName);
    }

    public void clickWeekendFilter() {
        driver.findElement(By.xpath("//button[contains(text(),'Weekend')]")).click();
    }

    public void clickClearAll() {
        driver.findElement(By.xpath("//button[contains(text(),'Clear')]")).click();
    }

    public int getCount() {
        String text = driver.findElement(eventCount).getText();
        return Integer.parseInt(text);
    }
}