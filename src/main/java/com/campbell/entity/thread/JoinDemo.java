package com.campbell.entity.thread;

/**
 * @author Campbell
 * @date 2020/9/1
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(JoinDemo::test);
        t.start();
        System.out.println("开始");
        t.join();
        System.out.println("子线程执行完成以后再执行");
    }

    public static void test() {
        try {
            int value = (int) (Math.random() * 10000);
            System.out.println("需要等待" + value + "毫秒");
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
