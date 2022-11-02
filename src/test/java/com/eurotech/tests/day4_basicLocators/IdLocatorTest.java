package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.GetDriver("chrome");
        Faker fk = new Faker();
        driver.get("https://demoqa.com/text-box");
        Set<Cookie> allcookies = driver.manage().getCookies();
        System.out.println(allcookies);
        WebElement inputUserName = driver.findElement((By.id("userName")));
        // WebElement inputUserName2 = driver.findElement((By.cssSelector("userName")));

        inputUserName.sendKeys((fk.name().fullName()));

        WebElement inputUserEmail = driver.findElement(By.id("userEmail"));
        inputUserEmail.sendKeys(fk.internet().emailAddress());
        Thread.sleep(2000);


    }
}
