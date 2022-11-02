package com.eurotech.tests.day15_POM;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void wrongPassword() {
        driver.get(ConfigurationReader.get("url"));

        loginPage.understandBtn.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        loginPage.passwordInput.sendKeys("somePassword");
        loginPage.loginBtn.click();
        String actualMessage = loginPage.warningMessage.getText();
        Assert.assertEquals(actualMessage, "Invalid Credentials!");

    }

    @Test
    public void wrongUsername() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.usernameInput.sendKeys("SomeUser@gmail.com");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.understandBtn.click();
        loginPage.loginBtn.click();
        String actualMessage = loginPage.warningMessage.getText();
        Assert.assertEquals(actualMessage, "Invalid Credentials!");
    }
}

