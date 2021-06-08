package com.campbell.entity.thread;

import java.util.concurrent.Exchanger;

/**
 * @author Campbell
 * @date 2021/6/8
 */
public class ExchangerDemo {

    public static void begin(Exchanger<String> exchanger, String s) {
        try {
            String result = exchanger.exchange(s);
            System.out.println(Thread.currentThread().getName() + " " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(()->begin(exchanger, "线程A的消息"),"线程A").start();
        new Thread(()->begin(exchanger, "线程B的消息"),"线程B").start();
    }
}
