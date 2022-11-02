package com.eurotech.tests.day10_TypeOfElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.GetDriver("chrome");
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=04226");
    }

    @Test
    public void test1() throws InterruptedException {

        WebElement Confirm = driver.findElement(By.xpath("(//span[text()='Confirm'])[1]"));
        Confirm.click();
        WebElement YesSubmit = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]"));
        Thread.sleep(2000);
        YesSubmit.click();
    }

    @AfterMethod
    public void teardown() {
        //driver.close();
    }
}
