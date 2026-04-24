package com.bms.tests;

import com.bms.base.BaseClass;
import com.bms.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class ContentValidationTest extends BaseClass {

    @Test(priority = 1, description = "Verify Promo IFrame and Language Collections")
    public void validatePageContent() {
        HomePage home = new HomePage(driver);

        // 1. Test IFrame Switching
        home.switchToPromoFrame();
        // The promo frame contains a heading (h2)
        String promoText = driver.findElement(By.tagName("h2")).getText();
        System.out.println("Promo Found: " + promoText);
        Assert.assertFalse(promoText.isEmpty(), "IFrame content should not be empty");

        // 2. Switch back to main content
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.className("logo")).isDisplayed(), "Failed to switch back from IFrame");

        // 3. Test Collections (Languages) on Sports Page
        home.goToSports();
        List<WebElement> langs = driver.findElements(By.cssSelector("#lang-list li"));

        System.out.println("Languages available: " + langs.size());

        // TC: Verify languages are printed and list is not empty
        Assert.assertTrue(langs.size() > 0, "Language collection should not be empty");

        for(WebElement lang : langs) {
            System.out.println("Language Option: " + lang.getText());
        }
    }
}