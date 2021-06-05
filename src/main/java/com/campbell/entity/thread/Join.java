package com.campbell.entity.thread;


/**
 * @author Campbell
 * @date 2021/6/2
 */
public class Join {

    public static void begin(Thread thread) {
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
        Thread t1 = new Thread(() -> begin(null));
        Thread t2 = new Thread(() -> begin(t1));
        Thread t3 = new Thread(() -> begin(t2));
        t1.start();
        t2.start();
        t3.start();
    }
}
