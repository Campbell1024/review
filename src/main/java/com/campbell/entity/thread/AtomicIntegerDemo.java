package com.campbell.entity.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Campbell
 * @date 2020/8/29
 */
public class AtomicIntegerDemo {

    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        AtomicIntegerDemo atomicTest = new AtomicIntegerDemo();
        for (int i = 1; i < 4; i++) {
            new Thread(atomicTest::test, "线程" + i).start();
        }
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicTest.count);
    }

    public void test() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            count.incrementAndGet();
        }
    }
}
