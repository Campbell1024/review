package com.campbell.entity.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition接口实现生产者和消费者队列，以买包子为例
 *
 * @author Campbell
 * @date 2020/8/7
 */
public class ConditionDemo {
    //有没有包子
    private boolean flag;
    //包子的数量
    private int count;

    private Lock lock = new ReentrantLock();

    private Condition producer = lock.newCondition();

    private Condition consumer = lock.newCondition();

    public static void main(String[] args) {
        ConditionDemo conditionTest = new ConditionDemo();
        Runnable productRun = () -> {
            while (true) {
                conditionTest.product();
            }
        };
        Runnable consumeRun = () -> {
            while (true) {
                conditionTest.consume();
            }
        };
        new Thread(productRun, "后厨1").start();
        new Thread(productRun, "后厨2").start();
        new Thread(consumeRun, "顾客1").start();
        new Thread(consumeRun, "顾客2").start();
    }

    public void product() {
        lock.lock();
        while (flag == true) {
            try {
                producer.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "正在生产第" + count + "个包子");
        flag = true;
        consumer.signalAll();
        lock.unlock();
    }

    public void consume() {
        lock.lock();
        while (flag == false) {
            try {
                consumer.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "正在消费第" + count + "个包子");
        flag = false;
        producer.signalAll();
        lock.unlock();
    }

}
