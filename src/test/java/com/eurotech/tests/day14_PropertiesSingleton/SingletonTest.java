package com.eurotech.tests.day14_PropertiesSingleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {
    @Test
    public void testName() {
        //Singleton singleton = new Singleton();

        String driver1 = Singleton.getInstance();
        String driver2 = Singleton.getInstance();
    }

    @Test
    public void test2() {
        WebDriver driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));

    }

    @Test
    public void test33() {
        WebDriver driver = Driver.get();
        driver.get(ConfigurationReader.get("http://www.google.com"));

    }

    @Test
    public void test4() {
        WebDriver driver = Driver.get();
        driver.get(ConfigurationReader.get("http://www.google.com"));
    }


}
