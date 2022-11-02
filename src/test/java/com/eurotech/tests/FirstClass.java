package com.eurotech.tests;

import com.github.javafaker.Faker;

class myint {
    public static int a;
}

public class FirstClass extends myint {


    public static void main(String[] args) {
        //System.out.println("hello world");
        Faker fk = new Faker();
        System.out.println(fk.address().cityName());

        a += a;

        if (a < 10) {
            System.out.println(a);
            new FirstClass();
            String[] str = {"ali", "veli"};
            FirstClass.main(str);
        } else {
            System.out.println("bit artik");
        }
    }
}
