package com.campbell.entity;

/**
 * @author Campbell
 * @date 2020/9/24
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

}
