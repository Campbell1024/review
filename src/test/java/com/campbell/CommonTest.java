package com.campbell;

import com.campbell.entity.Person;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Campbell
 * @date 2020/8/2
 */
public class CommonTest {

    @Test
    public void testBigDecimal() {
        BigDecimal bigDecimal = new BigDecimal("2.345");
        System.out.println(bigDecimal.divide(BigDecimal.valueOf(2), 2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void testDate() {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());
        date.setTime(0);
        System.out.println(date);

        System.out.println("----------分割线----------");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        System.out.println(time);

        String time2 = "2020-01-01 12:00:00";
        try {
            Date date1 = sdf.parse(time2);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalendar() {
        System.out.println("请输入年份：");
        int year = new Scanner(System.in).nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 2, 1);
        calendar.add(Calendar.DATE, -1);
        int day = calendar.get(Calendar.DATE);
        System.out.println(day);
    }

    @Test
    public void testSystem() {
        new Person();
        new Person();
        new Person();
        new Person();
        new Person();
        System.gc();
    }
}
