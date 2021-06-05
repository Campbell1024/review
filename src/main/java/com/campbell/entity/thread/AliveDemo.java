package com.campbell.entity.thread;

/**
 * @author Campbell
 * @date 2020/8/16
 */
public class AliveDemo {

    public static void begin() {
        System.out.println("线程状态：" + Thread.currentThread().isAlive());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(AliveDemo::begin, "test");
        System.out.println("启动前test线程状态：" + thread.isAlive());
        thread.start();
        System.out.println("启动后test线程状态：" + thread.isAlive());
    }

}
