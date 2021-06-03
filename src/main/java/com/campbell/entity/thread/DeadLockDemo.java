package com.campbell.entity.thread;

/**
 * @author Campbell
 * @date 2020/8/4
 */
public class DeadLockDemo {

    public static class Lock1 {
        public static Lock1 lock1 = new Lock1();
    }

    public static class Lock2 {
        public static Lock2 lock2 = new Lock2();
    }

    public static void main(String[] args) {
        new Thread(() -> testDeadLock(true)).start();
        new Thread(() -> testDeadLock(false)).start();
    }

    public static void testDeadLock(boolean flag) {
        if (flag) {
            //线程获取r1对象锁
            synchronized (Lock1.lock1) {
                System.out.println("if...获取r1锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Lock2.lock2) {
                    //线程获取r2对象锁
                    System.out.println("if...获取r2锁");
                }
            }
        } else {
            //线程获取r2对象锁
            synchronized (Lock2.lock2) {
                System.out.println("else...获取r2锁");
                //线程获取r1锁
                synchronized (Lock1.lock1) {
                    System.out.println("else...获取r1锁");
                }
            }
        }
    }

}
