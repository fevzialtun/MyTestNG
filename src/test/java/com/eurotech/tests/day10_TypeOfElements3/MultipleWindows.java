package com.eurotech.tests.day10_TypeOfElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = WebDriverFactory.GetDriver("chrome");
    }

    @Test
    public void twoWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        String title = driver.getTitle();
        System.out.println("Title before click = " + title);
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(1000);

        String currentTab = driver.getWindowHandle();
        System.out.println("currentTab = " + currentTab);
        Set<String> tabs = driver.getWindowHandles();
        String SecondTab = "";
        for (String tab : tabs) {
            if (tab != currentTab) {
                SecondTab = tab;
            }
        }
        System.out.println("SecondTab = " + SecondTab);
        driver.switchTo().window(SecondTab);

        String secondtitle = driver.getTitle();

        System.out.println("Title after click = " + secondtitle);

        Assert.assertNotEquals(title, secondtitle, "verify that the pages are Not Same");
    }

    @Test
    public void multipleWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        //for (WebElement element : driver.findElements(By.xpath("a"))) {
        //    System.out.println(driver.switchTo().activeElement().getText());
        // }
        WebElement click_here = driver.findElement(By.linkText("click Here"));
        click_here.click();
        Thread.sleep(2000);
        //driver.navigate().to();
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());


        Set<String> tabs = driver.getWindowHandles();


        String title = driver.getTitle();


    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
