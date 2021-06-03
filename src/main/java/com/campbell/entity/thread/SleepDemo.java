package com.campbell.entity.thread;

/**
 * @author Campbell
 * @date 2020/8/16
 */
public class SleepDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(SleepDemo::sleep);
        System.out.println("开始于：" + System.currentTimeMillis());
        thread.start();
        System.out.println("结束于：" + System.currentTimeMillis());
    }

    public static void sleep() {
        System.out.println("线程开始于：" + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程结束于：" + System.currentTimeMillis());
    }

}
