package com.campbell.entity;

/**
 * @author Campbell
 * @date 2020/7/5
 */
public class Safe {

    private int count = 0;

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

    public static void main(String[] args) {
        Safe safe = new Safe();
        long start = System.currentTimeMillis();
        new Thread(() -> safe.add()).start();
        new Thread(() -> safe.add()).start();
        long end = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(safe.count);
        System.out.println(end - start);

    }
}
