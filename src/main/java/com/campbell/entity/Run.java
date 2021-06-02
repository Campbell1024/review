package com.campbell.entity;

import lombok.Data;

/**
 * @author Campbell
 * @date 2021/6/2
 */
@Data
public class Run implements Runnable {

    private Thread thread;

    public Run() {
    }

    public Run(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        if (null != thread) {
            try {
                thread.join();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "执行中");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Run(), "线程A");
        Thread t2 = new Thread(new Run(t1), "线程B");
        Thread t3 = new Thread(new Run(t2), "线程C");
        t1.start();
        t2.start();
        t3.start();
    }
}
