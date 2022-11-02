package com.eurotech.tests.day20_DDF;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {


    @DataProvider
    public Object[][] userData() {
        String path = System.getProperty("user.dir") + "/src/test/resources/EurotechTest.xls";
        //System.out.println("path = " + path);
        ExcelUtil testData = new ExcelUtil(path, "Test Data");
        return testData.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "userData")
    public void DDFLoginTest(String Username, String Password, String Title, String Company, String Name) throws InterruptedException {
        LoginPage loginpage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        extentLogger = report.createTest(Name + "'s Login Test");

        //driver.get("url");
        loginpage.understandBtn.click();

        extentLogger.info("Enter username");
        loginpage.usernameInput.sendKeys(Username);
        extentLogger.info("Enter password");
        loginpage.passwordInput.sendKeys(Password);
        extentLogger.info("Press Login Button");
        loginpage.loginBtn.click();
        Thread.sleep(1000);
        extentLogger.info("Verify that user is logged in");

        String expectedMessage = "Welcome " + Name;
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), expectedMessage);


        extentLogger.info("Verify that title is :" + Title);
        Assert.assertEquals(dashboardPage.getTitle(Title), Title);

        extentLogger.info("Verify that " + Name + " is working at :" + Company);
        Assert.assertEquals(dashboardPage.getCompany(Company), Company);


        extentLogger.pass("PASSED");
    }

}
