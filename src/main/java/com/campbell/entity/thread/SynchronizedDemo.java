package com.campbell.entity.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Campbell
 * @date 2020/7/5
 */
public class SynchronizedDemo {

    private static int amount = 100;

    private static int count = 0;

    private static final Object lock = new Object();

    private static final Lock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(SynchronizedDemo::begin, "窗口1").start();
        new Thread(SynchronizedDemo::begin, "窗口2").start();
        new Thread(SynchronizedDemo::begin, "窗口3").start();
    }

    public static void begin() {
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
                } else {
                    break;
                }
            }*/
            try {
                reentrantLock.lock();
                if (amount > 0) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "已卖出" + (++count) + "张票");
                    System.out.println("剩余" + (--amount) + "张票");
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
