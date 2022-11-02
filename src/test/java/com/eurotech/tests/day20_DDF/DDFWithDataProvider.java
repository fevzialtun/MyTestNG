package com.eurotech.tests.day20_DDF;

import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {
    @DataProvider
    public Object[][] testData() {

        String[][] data = {
                {"Game of Thrones", "7.5"},
                {"Sherlock Holmes", "9"},
                {"Lord of the Rings", "8"},
                {"Breaking Bad", "5"},
                {"Prison Break", "6"},
                {"Wikings", "6"},
                {"Kurtlar Vadisi", "9"}

        };
        return data;
    }

    @DataProvider
    public Object[][] Eurotech() {
        String path = System.getProperty("user.dir") + "/src/test/resources/EurotechTest.xls";
        //System.out.println("path = " + path);
        ExcelUtil testData = new ExcelUtil(path, "Test Data");
        //List<Map<String, String>> dataList = testData.getDataList();
        return testData.getDataArrayWithoutFirstRow();

    }

    @Test(dataProvider = "testData")
    public void testTvShow(String tvShow, String rating) {
        System.out.println("Tv Show " + tvShow + " has a rating of " + rating);
    }

    @Test(dataProvider = "Eurotech")
    public void testEurotech_users(String email, String name) {
        System.out.println(email + " " + name);
    }

}
