package com.eurotech.tests.day12_action_Js;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = WebDriverFactory.GetDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));

        Actions actions = new Actions(driver);
        //Thread.sleep(2000);
        actions.moveToElement(img2).perform();


        WebElement view_profile1 = driver.findElement(By.linkText("View profile"));
        System.out.println("view_profile1.getText() = " + view_profile1.getText());

        Assert.assertTrue(view_profile1.isDisplayed(), "Verify that the img1 text is displayed");


    }

    @Test
    public void dragAndDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));


        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();

        final WebElement verifyMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));

        Assert.assertEquals(verifyMessage.getText(), "Dropped!", "Verify that the drag and drop works");
    }

    @Test
    public void drugAndDrop2() {

        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));


        Actions actions = new Actions(driver);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(3000).release().perform();

        final WebElement verifyMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));

        Assert.assertEquals(verifyMessage.getText(), "Dropped!", "Verify that the drag and drop works");

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
