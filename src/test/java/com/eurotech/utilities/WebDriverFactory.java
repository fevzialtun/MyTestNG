package com.eurotech.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

    public static WebDriver GetDriver(String BrowserType) {
        WebDriver Driver = null;
        switch (BrowserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                Driver = new ChromeDriver(); // poly
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                Driver = new OperaDriver(); // poly
                break;
        }
        return Driver;
    }
}
