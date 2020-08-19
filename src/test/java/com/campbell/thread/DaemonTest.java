package com.campbell.thread;

/**
 * @author Campbell
 * @date 2020/8/17
 */
public class DaemonTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("time=" + System.currentTimeMillis());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);  // 把指定的线程设置为守护线程
        t.start();
        Thread.sleep(3000);
        System.out.println("主线程结束");
    }
}
