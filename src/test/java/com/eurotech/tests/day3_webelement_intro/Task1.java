package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver Driver = WebDriverFactory.GetDriver("Chrome");

        Driver.get("https://tr-tr.facebook.com/");

        WebElement loginBtn = Driver.findElement(By.name("login"));

        String expectedUrl = "https://www.facebook.com/mymailname";

        Thread.sleep(1000);

        Driver.findElement(By.id("email")).sendKeys("myemailname@hohmail.com");
        Driver.findElement(By.id("pass")).sendKeys("Mypassword");
        Thread.sleep(1000);
        loginBtn.click();
        Thread.sleep(2000);
        if (expectedUrl.equals(Driver.getCurrentUrl())) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

    }
}
