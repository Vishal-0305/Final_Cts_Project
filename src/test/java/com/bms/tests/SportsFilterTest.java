package com.bms.tests;

import com.bms.base.BaseClass;
import com.bms.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class SportsFilterTest extends BaseClass {

    @Test(priority = 1, description = "Verify sports search and weekend filtering")
    public void validateSportsSearchAndFilter() {
        HomePage home = new HomePage(driver);

        // 1. Navigate to Sports
        home.goToSports();
        Assert.assertTrue(driver.getCurrentUrl().contains("sports"), "Search failed: Not on sports page");

        // 2. Test Search Functionality


        // Using a direct click for the weekend button
        driver.findElement(By.xpath("//button[text()='This Weekend']")).click();

        int weekendCount = home.getVisibleEventCount();
        Assert.assertTrue(weekendCount < 20 && weekendCount > 0, "Weekend filter should show a subset of events");
    }
}