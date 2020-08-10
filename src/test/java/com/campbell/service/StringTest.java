package com.campbell.service;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Scanner;

/**
 * @author Campbell
 * @date 2020/8/8
 */
public class StringTest {

    /**
     * 小写转大写
     */
    @Test
    public void testUpperCase() {
        System.out.println("请输入字符串：");
        String str = new Scanner(System.in).nextLine();
        char[] ch = str.toCharArray();
        ch[0] = String.valueOf(ch[0]).toUpperCase().charAt(0);
        System.out.println(new String(ch));

        System.out.println(String.valueOf(str.charAt(0)).toUpperCase().concat(str.substring(1)));

        System.out.println(str.substring(0, 1).toUpperCase().concat(str.substring(1)));
    }

    /**
     * 正则表达式
     */
    @Test
    public void testMatch() {
        String tel = "18896813767";
        String telReg = "1[345678][0-9]{9}";
        boolean flag = tel.matches(telReg);
        System.out.println(flag);

        byte[] bytes = tel.getBytes();
        System.out.println(bytes);

        char[] chars = tel.toCharArray();
        System.out.println(chars);
    }

    /**
     * 字符串格式化
     */
    @Test
    public void testFormat() {
        String nameResult = String.format("Hi,%s", "admin");
        System.out.println(nameResult);

        String numResult = String.format("%08d", 1);
        System.out.println(numResult);

        System.out.println(String.format("%tF %<tT%n", new Date()));
        System.out.printf("%tF %<tT%n", new Date());

        System.out.println(String.format("%.2f", 3.145));
    }
}
