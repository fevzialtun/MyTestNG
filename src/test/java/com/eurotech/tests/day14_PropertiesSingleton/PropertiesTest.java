package com.eurotech.tests.day14_PropertiesSingleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {
    @Test
    public void test1() {
        String browser = ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);
    }

    @Test
    public void openBrowserUsingConfigurationReader() throws InterruptedException {
        WebDriver driver = WebDriverFactory.GetDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));
        //Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='I understand']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(ConfigurationReader.get("usernameTeacher"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(ConfigurationReader.get("passwordTeacher") + Keys.ENTER);
        //driver.findElement(By.xpath("//input[@id='loginpage-form-btn']")).click();
        Thread.sleep(2000);


    }

    @Test
    public void test2() {

    }
}
