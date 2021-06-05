package com.campbell.entity.thread;

import cn.hutool.core.date.DateUtil;

/**
 * @author Campbell
 * @date 2020/8/26
 */
public class VolatileDemo {

    public static volatile boolean flag = true;

    public static void begin() {
        System.out.println("开始");
        while (flag) {
            System.out.println(DateUtil.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("结束");
    }

    public static void main(String[] args) {
        new Thread(VolatileDemo::begin).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "准备停止");
        flag = false;
    }

}
