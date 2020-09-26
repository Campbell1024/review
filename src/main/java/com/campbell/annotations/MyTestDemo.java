package com.campbell.annotations;

/**
 * @author Campbell
 * @date 2020/9/26
 */
public class MyTestDemo {

    @MyTest
    public void test01() {
        System.out.println("test01");
    }

    public void test02() {
        System.out.println("test02");
    }

    @MyTest
    public void test03() {
        System.out.println("test03");
    }
}
