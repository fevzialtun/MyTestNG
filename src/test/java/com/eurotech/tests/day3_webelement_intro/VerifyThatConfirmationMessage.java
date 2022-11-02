package com.eurotech.tests.day3_webelement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
        // verify that welcome message is "Welcome Eurotech"

        WebDriver Driver = WebDriverFactory.GetDriver("Chrome");

        Driver.get("http://eurotech.study/login");
        WebElement cookienbtn = Driver.findElement(By.id("rcc-confirm-button"));
        WebElement loginbtn = Driver.findElement(By.id("loginpage-form-btn"));
        System.out.println("loginbtn = " + loginbtn);

        //for (element: Driver.findElements().subList(1,Driver.findElements().size())) {

        //}

        // System.out.println(cookienbtn.getLocation());
        String expectedUrl = "http://eurotech.study/dashboard";
        Thread.sleep(1000);
        cookienbtn.click();
        Thread.sleep(1000);

        Driver.findElement(By.id("loginpage-input-email")).sendKeys("eurotech@gmail.com");
        Driver.findElement(By.id("loginpage-form-pw-input")).sendKeys("Test12345!");


        loginbtn.click();
        Thread.sleep(1000);
        if ((Driver.findElement(By.id("dashboard-p1")).getText()).equals("Welcome Eurotech")) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

    }
}
