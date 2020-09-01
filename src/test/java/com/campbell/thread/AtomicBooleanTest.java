package com.campbell.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * CAS乐观锁
 *
 * @author Campbell
 * @date 2020/8/30
 */
public class AtomicBooleanTest {

    private AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        AtomicBooleanTest atomicBooleanTest = new AtomicBooleanTest();
        new Thread(atomicBooleanTest::compareAndSwap, "线程1").start();
        new Thread(atomicBooleanTest::compareAndSwap, "线程2").start();
    }

    public void compareAndSwap() {
        System.out.println(Thread.currentThread().getName() + "获取flag：" + flag.get());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (flag.compareAndSet(true, false)) {
            System.out.println(Thread.currentThread().getName() + "将flag修改为" + flag.get());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag.set(true);
        } else {
            System.out.println(Thread.currentThread().getName() + "正在重试，flag：" + flag.get());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            compareAndSwap();
        }
    }
}
