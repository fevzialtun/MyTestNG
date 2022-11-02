package com.eurotech.tests.day8_typeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckBoxDemo {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.GetDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement sports = driver.findElement(By.cssSelector("#hobbies-checkbox-1"));
        WebElement reading = driver.findElement(By.cssSelector("#hobbies-checkbox-2"));
        WebElement music = driver.findElement(By.cssSelector("#hobbies-checkbox-3"));

        Assert.assertFalse(sports.isSelected(), "Verify that sports is NOT checked");

        sports.click();
        Thread.sleep(6000);
        Assert.assertTrue(sports.isSelected(), "Verify that sports is checked");

    }

    @AfterMethod
    public void afterMethod() {


    }
}
