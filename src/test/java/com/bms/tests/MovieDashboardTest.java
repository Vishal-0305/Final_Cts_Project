package com.bms.tests;

import com.bms.base.BaseClass;
import com.bms.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MovieDashboardTest extends BaseClass {
    @Test
    public void testMovieDisplay() {
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.getAllMovies().size() >= 8);
    }
}