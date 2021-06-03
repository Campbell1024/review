package com.campbell.entity.thread;

/**
 * @author Campbell
 * @date 2020/7/24
 */
public class ThreadDemo {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("thread");
        myThread.start();
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());
    }
}
