package com.campbell.thread;

import com.campbell.util.StringMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Campbell
 * @date 2020/8/8
 */
public class TimerTest {

    public static void main(String[] args) {
        System.out.println("请输入定时时间（例如：2020-08-08 00:00:00）：");
        String timeString = new Scanner(System.in).nextLine();
        /*String timeReg = "((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))";
        while (!timeString.matches(timeReg)) {
            System.out.println("格式错误！请重新输入：");
            timeString = new Scanner(System.in).nextLine();
        }*/
        while (!StringMap.isMatch(timeString)) {
            System.out.println("格式错误！请重新输入：");
            timeString = new Scanner(System.in).nextLine();
        }
        System.out.println("请输入间隔时间（s）：");
        Integer time = new Scanner(System.in).nextInt();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("线程定时任务");
            }
        }, date, time * 1000);
    }

}
