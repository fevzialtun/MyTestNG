package com.eurotech.tests.day5;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homework {
    public static void main(String[] args) throws InterruptedException {
        WebDriver Driver = WebDriverFactory.GetDriver("Chrome");
        System.out.println("Amazon : " + ((amazon(Driver)) ? "Passed" : "Failed"));

        System.out.println("Ebay : " + ((ebay(Driver)) ? "Passed" : "Failed"));

    }

    public static boolean amazon(WebDriver Driver) throws InterruptedException {
        Driver.get("http://www.amazon.com");
        WebElement searchInput = Driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.click();
        searchInput.sendKeys("apple");
        WebElement searchButton = Driver.findElement((By.id("nav-search-submit-button")));
        searchButton.click();
        Thread.sleep(3000);

        WebElement resultText = Driver.findElement(By.xpath("(//span[contains(text(),' of over ')]/..)/span[3]"));

        if (resultText.getText().contains("apple")) {
            System.out.println("resultText.getText() = " + resultText.getText());
            return true;
        } else {
            return false;
        }
    }

    public static boolean ebay(WebDriver Driver) throws InterruptedException {
        Driver.get("http://www.ebay.com");
        WebElement searchInput = Driver.findElement(By.id("gh-ac"));
        searchInput.click();
        searchInput.sendKeys("apple");
        WebElement searchButton = Driver.findElement((By.id("gh-btn")));
        searchButton.click();
        Thread.sleep(3000);

        WebElement resultText = Driver.findElement(By.xpath("//h1[contains(@class,'srp-controls' )]/span[2]"));


        if (resultText.getText().equals("apple")) {
            System.out.println("resultText.getText() = " + resultText.getText());
            return true;
        } else {
            return false;
        }
    }
}
