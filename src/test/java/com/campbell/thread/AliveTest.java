package com.campbell.thread;

/**
 * @author Campbell
 * @date 2020/8/16
 */
public class AliveTest {

    public static void main(String[] args) {
        Thread thread = new Thread(AliveTest::test, "test");
        System.out.println("启动前test线程状态：" + thread.isAlive());
        thread.start();
        System.out.println("启动后test线程状态：" + thread.isAlive());
    }

    public static void test() {
        System.out.println("线程状态：" + Thread.currentThread().isAlive());
    }

}
