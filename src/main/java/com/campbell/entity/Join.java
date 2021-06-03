package com.campbell.entity;


/**
 * @author Campbell
 * @date 2021/6/2
 */
public class Join {

    public static void start(Thread thread) {
        try {
            if (null != thread) {
                thread.join();
            }
            System.out.println(Thread.currentThread().getName() + "开始");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> Join.start(null));
        Thread t2 = new Thread(() -> Join.start(t1));
        Thread t3 = new Thread(() -> Join.start(t2));
        t1.start();
        t2.start();
        t3.start();
    }
}
