package com.campbell.entity.thread;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @author Campbell
 * @date 2020/8/7
 */
public class ThreadPoolDemo {

    public static String[] callString(String s) {
        return s.split(",");
    }

    public static Integer callSum() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<String[]> callableString = () -> callString("a,b,c,d");
        Callable<Integer> callableInteger = ThreadPoolDemo::callSum;
        Future<String[]> stringFuture = executorService.submit(callableString);
        Future<Integer> integerFuture = executorService.submit(callableInteger);
        try {
            System.out.println(Arrays.toString(stringFuture.get()));
            System.out.println(integerFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

}
