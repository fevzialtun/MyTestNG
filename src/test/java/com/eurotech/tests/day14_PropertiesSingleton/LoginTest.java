package com.eurotech.tests.day14_PropertiesSingleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        //driver.findElement(By.xpath("//button[text()='I understand']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(ConfigurationReader.get("usernameTeacher"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(ConfigurationReader.get("passwordTeacher") + Keys.ENTER);
        Thread.sleep(2000);
    }
}
