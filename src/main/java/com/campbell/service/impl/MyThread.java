package com.campbell.service.impl;

/**
 * @author Campbell
 * @date 2020/7/24
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(getName());
    }
}
