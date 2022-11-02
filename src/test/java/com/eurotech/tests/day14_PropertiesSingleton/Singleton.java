package com.eurotech.tests.day14_PropertiesSingleton;

public class Singleton {
    private static String str;

    //singlethon class will have private constructor
    //other classes cannot create an instance of this class
    private Singleton() {
    }

    public static String getInstance() {

        if (str == null) {
            System.out.println("str is null assign a value");
            str = "webdriver1";
            System.out.println("str = " + str);
        } else {
            System.out.println("str = " + str);
        }
        return str;
    }
}
