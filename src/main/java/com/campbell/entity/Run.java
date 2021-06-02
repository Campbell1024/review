package com.campbell.entity;


import java.util.concurrent.CountDownLatch;

/**
 * @author Campbell
 * @date 2021/6/2
 */
public class Run implements Runnable {

    private Thread thread;

    public Run() {
    }

    public Run(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            if (null != thread) {
                thread.join();
            }
            System.out.println(Thread.currentThread().getName() + "开始");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Run(), "线程A");
        Thread t2 = new Thread(new Run(t1), "线程B");
        Thread t3 = new Thread(new Run(t2), "线程C");
        t1.start();
        t2.start();
        t3.start();
    }
}
