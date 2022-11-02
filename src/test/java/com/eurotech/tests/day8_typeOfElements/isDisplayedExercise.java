package com.eurotech.tests.day8_typeOfElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class isDisplayedExercise {
    WebDriver driver = WebDriverFactory.GetDriver("chrome");


    @BeforeMethod
    public void setup() {

        //System.setProperty("webdriver.chrome.driver", "chrome loctions");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        // driver.quit();
    }

    @Test
    public void beforClickingTheButton() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement hello = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        WebElement startButton = driver.findElement(By.cssSelector("#start>Button"));

        System.out.println("'hello world!' text is displayable before clicking the button = " + hello.isDisplayed());
        Assert.assertFalse(hello.isDisplayed(), "verify that the text 'Hello World!' is NOT displayed by default");


    }

    @Test
    public void AfterClickingTheButton() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");


        WebElement hello = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        WebElement startButton = driver.findElement(By.cssSelector("#start>Button"));

        startButton.click();
        Thread.sleep(6000);

        System.out.println("hello world!' text is displayable after clicking the button = " + hello.isDisplayed());
        Assert.assertTrue(hello.isDisplayed(), "verify that the text 'Hello World!' is  displayed");
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
