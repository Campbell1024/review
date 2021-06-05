package com.campbell.entity.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Campbell
 * @date 2021/6/2
 */
public class CountDown {

    public static void begin(CountDownLatch current, CountDownLatch next) {
        try {
            current.await();
            System.out.println(Thread.currentThread().getName() + "开始");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        next.countDown();
    }

    public static void main(String[] args) {
        CountDownLatch c1 = new CountDownLatch(0);
        CountDownLatch c2 = new CountDownLatch(1);
        CountDownLatch c3 = new CountDownLatch(1);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> begin(c1, c2));
        executorService.submit(() -> begin(c2, c3));
        executorService.submit(() -> begin(c3, c3));
        executorService.shutdown();
    }
}
