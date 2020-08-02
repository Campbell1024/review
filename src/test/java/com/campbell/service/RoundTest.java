package com.campbell.service;

import com.campbell.ReviewApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author Campbell
 * @date 2020/7/31
 */
@Slf4j
public class RoundTest extends ReviewApplicationTests {

    /**
     * 九九乘法表
     */
    @Test
    public void testMultiply() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 打印三角形
     */
    @Test
    public void testTriangle() {
        System.out.println("请输入一个数：");
        int num = new Scanner(System.in).nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 等腰三角形
     */
    @Test
    public void testEquTriangle() {
        System.out.println("请输入一个数：");
        int num = new Scanner(System.in).nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }
            for (int x = 1; x <= (2 * i - 1); x++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 菱形
     */
    @Test
    public void testDiamond() {
        System.out.println("请输入一个数：");
        int num = new Scanner(System.in).nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }
            for (int x = 1; x <= (2 * i - 1); x++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int x = 1; x <= (2 * (num - i) - 1); x++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
