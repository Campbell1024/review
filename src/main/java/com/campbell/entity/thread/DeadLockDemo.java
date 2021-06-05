package com.campbell.entity.thread;

/**
 * @author Campbell
 * @date 2020/8/4
 */
public class DeadLockDemo {

    public static final Object o1 = new Object();

    public static final Object o2 = new Object();

    public static void begin(boolean flag) {
        if (flag) {
            //线程获取r1对象锁
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "获取锁o1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    //线程获取r2对象锁
                    System.out.println(Thread.currentThread().getName() + "获取锁o2");
                }
            }
        } else {
            //线程获取r2对象锁
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "获取锁o2");
                //线程获取r1锁
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "获取锁o1");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(() -> begin(true), "线程A").start();
        new Thread(() -> begin(false), "线程B").start();
    }

}
