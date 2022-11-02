package com.eurotech.tests.day12_action_Js;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HoverHomework {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = WebDriverFactory.GetDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testHover() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img;
        WebElement name;

        for (int i = 2; i < 5; i++) {
            img = driver.findElement(By.xpath("(//img)[" + i + "]"));
            Actions actions = new Actions(driver);
            Thread.sleep(2000);
            actions.moveToElement(img).perform();

            name = driver.findElement(By.xpath("(//h5)[" + (i - 1) + "]"));
            System.out.println("name = " + name.getText());
            String actualName = name.getText();

            Assert.assertEquals(actualName, "name: user" + (i - 1), "Verify that the image " + (i - 1) + " is hovered over and the name is displayed");
        }

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
