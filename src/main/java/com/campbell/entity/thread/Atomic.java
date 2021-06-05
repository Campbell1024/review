package com.campbell.entity.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Campbell
 * @date 2021/6/3
 */
public class Atomic {

    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void begin(int num) {
        while (true) {
            if (atomicInteger.get() == num) {
                System.out.println(Thread.currentThread().getName() + "开始");
                break;
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        atomicInteger.getAndIncrement();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> begin(0));
        executorService.submit(() -> begin(1));
        executorService.submit(() -> begin(2));
        executorService.shutdown();
    }
}
