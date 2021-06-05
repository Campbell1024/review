package com.campbell.entity.thread;

import java.util.concurrent.*;

/**
 * @author Campbell
 * @date 2020/9/3
 */
public class CallableDemo {

    public static String begin() {
        System.out.println("开始");
        return "callable";
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> stringFuture = executorService.submit(CallableDemo::begin);
        FutureTask<String> futureTask = new FutureTask<>(CallableDemo::begin);
        executorService.submit(futureTask);
        executorService.execute(futureTask);
        try {
            System.out.println(stringFuture.get());
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
