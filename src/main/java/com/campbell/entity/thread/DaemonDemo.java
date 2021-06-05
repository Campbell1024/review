package com.campbell.entity.thread;

import cn.hutool.core.date.DateUtil;

/**
 * 守护线程
 *
 * @author Campbell
 * @date 2020/8/17
 */
public class DaemonDemo {

    public static void begin(){
        try {
            while (true) {
                System.out.println(DateUtil.now());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(DaemonDemo::begin);
        t.setDaemon(true);
        t.start();
        Thread.sleep(3000);
        System.out.println("主线程结束");
    }
}
