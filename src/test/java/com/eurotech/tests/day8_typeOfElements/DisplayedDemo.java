package com.eurotech.tests.day8_typeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.GetDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement hello = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        WebElement startButton = driver.findElement(By.cssSelector("#start>Button"));
        System.out.println("hello.isDisplayed() = " + hello.isDisplayed());
        Assert.assertFalse(hello.isDisplayed(), "verify that the element is NOT displayed");

        startButton.click();
        Thread.sleep(5000);
        Assert.assertTrue(hello.isDisplayed(), "verify that the element is  displayed");
        System.out.println("hello.isDisplayed() = " + hello.isDisplayed());


        driver.close();
    }
}
