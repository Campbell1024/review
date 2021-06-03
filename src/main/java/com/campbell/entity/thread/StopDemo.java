package com.campbell.entity.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Campbell
 * @date 2020/8/26
 */
public class StopDemo {

    public boolean flag = true;

    public static void main(String[] args) {
        StopDemo stopTest = new StopDemo();
        new Thread(stopTest::test).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopTest.stopThread();
    }

    public void test() {
        while (flag) {
            System.out.println("time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程执行结束");
    }

    public void stopThread() {
        flag = false;
    }

}
