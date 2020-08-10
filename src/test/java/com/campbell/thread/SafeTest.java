package com.campbell.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Campbell
 * @date 2020/7/5
 */
public class SafeTest {

    private static int amount = 100;
    private static int modCount = 0;
    private static Object lock = new Object();
    private static Lock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        //lambda表达式
        Runnable runnable = () -> ticket();
        //方法引用
        Runnable run = SafeTest::ticket;
        new Thread(run, "窗口1").start();
        new Thread(run, "窗口2").start();
        new Thread(run, "窗口3").start();
    }

    public static void ticket() {
        while (true) {
            /*synchronized (lock){
                if (amount > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + (amount--) + "张票");
                    System.out.println("已卖出"+(++modCount)+"张票");
                }else {
                    break;
                }
            }*/

            reentrantLock.lock();
            if (amount > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖第" + (amount--) + "张票");
                System.out.println("已卖出" + (++modCount) + "张票");
            }
            reentrantLock.unlock();
        }
    }
}
