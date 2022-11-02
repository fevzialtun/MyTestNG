package com.eurotech.tests.day20_DDF;

import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {

    @Test
    public void readExcelFile() {

        String path = System.getProperty("user.dir") + "/src/test/resources/EurotechTest.xls";
        System.out.println("path = " + path);
        ExcelUtil testData = new ExcelUtil(path, "Test Data");
        System.out.println("testData.getCellData(1,1) = " + testData.getCellData(1, 1));
        System.out.println("testData.getColumnsNames() = " + testData.getColumnsNames());
        System.out.println("testData.rowCount() = " + testData.rowCount());
        System.out.println("Arrays.stream(testData.getDataArrayWithoutFirstRow()).toArray().length = " + Arrays.stream(testData.getDataArrayWithoutFirstRow()).toArray().length);
        System.out.println("testData.columnCount() = " + testData.columnCount());
        final List<Map<String, String>> dataList = testData.getDataList();
        for (Map<String, String> oneRow : dataList) {
            System.out.println("oneRow.toString() = " + oneRow.toString());


        }
        System.out.println("dataList.get(3).get(\"Company\") = " + dataList.get(3).get("Company"));

    }
}
