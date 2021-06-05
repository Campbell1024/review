package com.campbell.entity.thread;

import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Campbell
 * @date 2020/8/26
 */
public class StopDemo {

    public static boolean flag = true;

    public static void main(String[] args) {
        new Thread(StopDemo::begin).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StopDemo.stopThread();
    }

    public static void begin() {
        while (flag) {
            System.out.println(DateUtil.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程执行结束");
    }

    public static void stopThread() {
        flag = false;
    }

}
