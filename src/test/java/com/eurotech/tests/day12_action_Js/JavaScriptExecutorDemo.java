package com.eurotech.tests.day12_action_Js;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = WebDriverFactory.GetDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void testNAme() {
        //driver.get("https://the-internet.herokuapp.com/dynamic_lcontrols");
        driver.get("https://www.amazon.co.uk");
        driver.findElement(By.id("sp-cc-accept")).click();
        driver.findElement(By.linkText("CONTINUE")).click();
        WebElement germany = driver.findElement(By.linkText("Germany"));
        System.out.println("germany.getText() = " + germany.getText());
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("argument[0].click()", germany);


    }

    @Test
    public void typeWithJS() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        String text = "Hello World!";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String longString = "argument[0].setAttribute('value', '" + text + "')";
        System.out.println("longString = " + longString);

        jse.executeScript("argument[0].setAttribute('value', '" + text + "')", inputBox);

    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("https://www.amazon.co.uk");
        driver.findElement(By.id("sp-cc-accept")).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }


    }

    @Test
    public void FileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\fevzi\\Desktop\\upload.txt");
        driver.findElement(By.id("file-submit")).click();
        String actualText = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualText, "upload.txt");

    }

    @Test
    public void test2() {
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/Eurotect.txt";
        System.out.println(projectPath + "/" + filePath);
        System.out.println(System.getProperty("path.separator"));
        System.out.println("System.getenv(\"Path\") = " + System.getenv("Path"));


    }

    @Test
    public void hoverHomework() {

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        // driver.quit();
    }

}
