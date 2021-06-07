package com.campbell.entity.thread;

import cn.hutool.core.date.DateUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Campbell
 * @date 2021/6/7
 */
public class CountDownLatchDemo {

    public static void begin(CountDownLatch count) {
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + DateUtil.now());
    }

    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(1);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> begin(count));
        }
        count.countDown();
        executorService.shutdown();
    }

}
