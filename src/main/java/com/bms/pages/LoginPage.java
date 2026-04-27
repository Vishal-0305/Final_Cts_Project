package com.bms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Locators
    By registerTab = By.id("register-tab");
    By loginForm = By.id("login-form");
    By regEmail = By.id("reg-email");
    By regPass = By.id("reg-password");
    By regBtn = By.id("register-btn");
    By logEmail = By.id("login-email");
    By logPass = By.id("login-password");
    By logBtn = By.id("login-btn");
    By authMsg = By.id("auth-message");
    By regName=By.id("reg-name");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public boolean isRegisterTabVisible() { return driver.findElement(registerTab).isDisplayed(); }

    public boolean isLoginFormDisplayed() { return driver.findElement(loginForm).isDisplayed(); }

    public void registerUser(String name,String email, String pass) {
        driver.findElement(registerTab).click();
        driver.findElement(regName).sendKeys(name);
        driver.findElement(regEmail).sendKeys(email);
        driver.findElement(regPass).sendKeys(pass);
        driver.findElement(regBtn).click();
    }

    public void loginUser(String email, String pass) {
        driver.findElement(logEmail).sendKeys(email);
        driver.findElement(logPass).sendKeys(pass);
        driver.findElement(logBtn).click();
    }

    public String getStatusMessage() {
        return driver.findElement(authMsg).getText();
    }
}