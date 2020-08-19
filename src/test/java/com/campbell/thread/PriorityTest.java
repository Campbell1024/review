package com.campbell.thread;

/**
 * @author Campbell
 * @date 2020/8/17
 */
public class PriorityTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "线程的优先级：" + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(1);
        System.out.println(Thread.currentThread().getName() + "线程的优先级：" + Thread.currentThread().getPriority());
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "线程的优先级：" + Thread.currentThread().getPriority())).start();
    }
}
