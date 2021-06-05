package com.campbell.entity.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition接口实现生产者和消费者队列
 *
 * @author Campbell
 * @date 2020/8/7
 */
public class ConditionDemo {

    /**
     * 是否生产
     */
    private static boolean flag;

    /**
     * 数量
     */
    private static int count;

    private static final Lock lock = new ReentrantLock();

    private static final Condition producer = lock.newCondition();

    private static final Condition consumer = lock.newCondition();

    public static void product() {
        while (true) {
            try {
                lock.lock();
                while (flag) {
                    producer.await();
                }
                count++;
                System.out.println(Thread.currentThread().getName() + "已生产第" + count + "个");
                flag = true;
                consumer.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void consume() {
        while (true) {
            try {
                lock.lock();
                while (!flag) {
                    consumer.await();
                }
                System.out.println(Thread.currentThread().getName() + "已消费第" + count + "个");
                flag = false;
                producer.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(ConditionDemo::product, "生产者A").start();
        new Thread(ConditionDemo::product, "生产者B").start();
        new Thread(ConditionDemo::product, "生产者C").start();
        new Thread(ConditionDemo::consume, "消费者A").start();
        new Thread(ConditionDemo::consume, "消费者B").start();
    }

}
