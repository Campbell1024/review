package com.campbell.entity.thread;

import cn.hutool.core.date.DateUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Campbell
 * @date 2021/6/8
 */
public class SemaphoreDemo {

    public static void begin(Semaphore semaphore) {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " " + DateUtil.now());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> begin(semaphore));
        }
        executorService.shutdown();
    }
}
