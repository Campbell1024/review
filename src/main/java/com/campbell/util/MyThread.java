package com.campbell.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Campbell
 * @date 2020/7/24
 */
public class MyThread extends Thread {

    public volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("开始");
        while (flag) {
            System.out.println("time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("结束");
    }
}
