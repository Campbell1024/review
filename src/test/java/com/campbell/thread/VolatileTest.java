package com.campbell.thread;

import com.campbell.service.impl.MyThread;

/**
 * @author Campbell
 * @date 2020/8/26
 */
public class VolatileTest {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread::run).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "准备停止");
        myThread.flag = false;
    }

}
