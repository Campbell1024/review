package com.campbell.entity.thread;

/**
 * @author Campbell
 * @date 2020/8/26
 */
public class InterruptDemo {

    public static void main(String[] args) {
        InterruptDemo interruptTest = new InterruptDemo();
        Thread t = new Thread(interruptTest::test);
        t.start();
        t.interrupt();
        System.out.println("是否停止1？" + t.isInterrupted());
        System.out.println("是否停止2？" + Thread.interrupted());
    }

    public void test() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("i=" + i);
        }
    }
}
