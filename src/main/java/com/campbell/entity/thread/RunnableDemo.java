package com.campbell.entity.thread;

/**
 * @author Campbell
 * @date 2020/7/24
 */
public class RunnableDemo {
    public static void main(String[] args) {
        /*MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        for (int i = 0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+""+i);
        }*/

        RunnableDemo runnableTest = new RunnableDemo();
        runnableTest.createThread();
    }

    /**
     * 匿名内部类写法
     */
    public void createThread() {
        /*Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("haha");
            }
        };
        new Thread(run).start();*/

        Thread thread = new Thread(() -> round(), "线程1");

        Runnable runnable = () -> round();
        Thread thread1 = new Thread(runnable, "线程2");

        thread.start();
        thread1.start();
    }

    public void round() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

}
