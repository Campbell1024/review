package com.campbell.entity.thread;

import cn.hutool.core.date.DateUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Campbell
 * @date 2021/6/7
 */
public class CyclicBarrierDemo {

    public static void begin(CyclicBarrier cyclicBarrier) {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + DateUtil.now());
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> begin(cyclicBarrier));
        }
        executorService.shutdown();
    }

}
