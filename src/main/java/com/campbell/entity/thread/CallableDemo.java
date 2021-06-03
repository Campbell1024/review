package com.campbell.entity.thread;

import java.util.concurrent.*;

/**
 * @author Campbell
 * @date 2020/9/3
 */
public class CallableDemo {

    public static void main(String[] args) {
        CallableDemo callableTest = new CallableDemo();

        FutureTask<String> futureTask = new FutureTask<>(callableTest::test);
        /*new Thread(futureTask).start();*/

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> stringFuture = executorService.submit(callableTest::test);
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

    public String test() {
        System.out.println("开始");
        return "callable";
    }
}
