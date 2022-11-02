package com.eurotech.tests.day12_action_Js;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = WebDriverFactory.GetDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@id='file-upload']"));
        chooseFileButton.sendKeys("asd");
        Thread.sleep(3000);
        System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(1000);
        //driver.quit();
    }

}
