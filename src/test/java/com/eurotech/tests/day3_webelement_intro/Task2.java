package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        Faker fk = new Faker();
        String emailFirstPart = fk.name().name().replace(" ", "");
        String emailSecondPart = "@" + "hotmail.com";

        WebDriver Driver = WebDriverFactory.GetDriver("Chrome");

        Driver.get("https://tr-tr.facebook.com/");
        WebElement emailInput = Driver.findElement(By.id("email"));
        WebElement passInput = Driver.findElement(By.id("pass"));
        WebElement loginBtn = Driver.findElement(By.name("login"));
        emailInput.sendKeys(emailFirstPart + emailSecondPart);
        passInput.sendKeys(fk.dog().name());

        String expectedUrl = "https://www.facebook.com/" + emailFirstPart;

        Thread.sleep(1000);
        //loginBtn.click();

        Thread.sleep(1000);
        String cuurentUrl = Driver.getCurrentUrl();
        if (cuurentUrl.equals(expectedUrl)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
        //Driver.close();
    }
}
