package com.campbell.entity.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * CAS乐观锁
 *
 * @author Campbell
 * @date 2020/8/30
 */
public class CompareAndSwapDemo {

    private static final AtomicBoolean flag = new AtomicBoolean(true);

    public static void begin() {
        System.out.println(Thread.currentThread().getName() + "获取flag：" + flag.get());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (flag.compareAndSet(true, false)) {
            System.out.println(Thread.currentThread().getName() + "将flag修改为" + flag.get());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag.set(true);
        } else {
            System.out.println(Thread.currentThread().getName() + "正在重试，flag：" + flag.get());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            begin();
        }
    }

    public static void main(String[] args) {
        new Thread(CompareAndSwapDemo::begin, "线程1").start();
        new Thread(CompareAndSwapDemo::begin, "线程2").start();
    }

}
