package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatUrlNotChanged {
    public static void main(String[] args) throws InterruptedException {

        WebDriver Driver = WebDriverFactory.GetDriver("Chrome");

        Driver.get("http://eurotech.study/login");
        WebElement cookienbtn = Driver.findElement(By.id("rcc-confirm-button"));
        WebElement loginbtn = Driver.findElement(By.id("loginpage-form-btn"));


        String expectedUrl = "http://eurotech.study/dashboard";

        Thread.sleep(1000);
        cookienbtn.click();
        Thread.sleep(1000);

        Driver.findElement(By.id("loginpage-input-email")).sendKeys("eurotech@gmail.com");
        Driver.findElement(By.id("loginpage-form-pw-input")).sendKeys("Test12345!");


        loginbtn.click();
        Thread.sleep(1000);
        String actualUrl = Driver.getCurrentUrl();
        // String expectedUrl = Driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        // Driver.close();
    }
}
