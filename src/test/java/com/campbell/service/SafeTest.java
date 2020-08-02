package com.campbell.service;

/**
 * @author Campbell
 * @date 2020/7/5
 */
public class SafeTest {

    private int count = 0;

    public static void main(String[] args) {
        SafeTest safeTest = new SafeTest();
        long start = System.currentTimeMillis();
        new Thread(() -> safeTest.add()).start();
        new Thread(() -> safeTest.add()).start();
        long end = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(safeTest.count);
        System.out.println(end - start);

    }

    public synchronized void add() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }
}
