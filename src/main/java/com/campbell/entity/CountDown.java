package com.campbell.entity;

import java.util.concurrent.CountDownLatch;

/**
 * @author Campbell
 * @date 2021/6/2
 */
public class CountDown implements Runnable {

    CountDownLatch current;

    CountDownLatch next;

    public CountDown(CountDownLatch current, CountDownLatch next) {
        this.current = current;
        this.next = next;
    }

    @Override
    public void run() {
        try {
            current.await();
            System.out.println(Thread.currentThread().getName() + "开始");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
        next.countDown();
    }

    public static void main(String[] args) {
        CountDownLatch c1 = new CountDownLatch(0);
        CountDownLatch c2 = new CountDownLatch(1);
        CountDownLatch c3 = new CountDownLatch(1);
        Thread t1 = new Thread(new CountDown(c1, c2), "线程A");
        Thread t2 = new Thread(new CountDown(c2, c3), "线程B");
        Thread t3 = new Thread(new CountDown(c3, c3), "线程C");
        t1.start();
        t2.start();
        t3.start();
    }
}
