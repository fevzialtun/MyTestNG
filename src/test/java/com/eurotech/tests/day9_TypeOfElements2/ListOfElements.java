package com.eurotech.tests.day9_TypeOfElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.GetDriver("chrome");
    }

    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> menuList = driver.findElements(By.xpath("//a[text()='A/B Testing']/../../li"));

        System.out.println("menuList.size() = " + menuList.size());
        int expectedSize = 44;
        int actualSize = menuList.size();

        Assert.assertEquals(actualSize, expectedSize, "Verify that menu size is 44");

        //print all elements text
        for (WebElement webElement : menuList) {
            System.out.println(webElement.getText());
        }

    }

    @Test
    public void test2() {
        driver.get("https://demoqa.com/elements");
        // task --> verifythat there are 6 elements in the menu
        List<WebElement> menuList = driver.findElements(By.cssSelector(".header-text"));
        System.out.println("menuList.size() = " + menuList.size());
        int expectedSize = 6;
        int actualSize = menuList.size();
        String message = "verify that there are " + menuList.size() + " elements in the main menu";
        Assert.assertEquals(actualSize, expectedSize, message);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
