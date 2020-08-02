package com.campbell.service;

import com.campbell.ReviewApplicationTests;
import com.campbell.utils.Sort;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

/**
 * @author Campbell
 * @date 2020/6/19
 */
@Slf4j
public class SortTest extends ReviewApplicationTests {

    public int[] inputArray() {
        System.out.println("请输入5个数字（以逗号分隔）：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] strings = str.split(",");
        int[] arr = new int[5];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        System.out.println("输入的数组：" + Sort.arrayToString(arr));
        return arr;
    }

    @Test
    public void testMinNum() {
        System.out.println("最小数字为：" + Sort.minNum(inputArray()));
    }

    @Test
    public void testBubbleSort() {
        int[] arr = inputArray();
        Sort.bubbleSort(arr);
        System.out.println("排序后的数组：" + Sort.arrayToString(arr));
    }

    @Test
    public void testSelectSort() {
        int[] arr = inputArray();
        Sort.selectSort(arr);
        System.out.println("排序后的数组：" + Sort.arrayToString(arr));
    }

    @Test
    public void testInsertSort() {
        int[] arr = inputArray();
        Sort.insertSort(arr);
        System.out.println("排序后的数组：" + Sort.arrayToString(arr));
    }

    @Test
    public void testBinarySearch() {
        int[] arr = inputArray();
        System.out.println("请输入查找的数字：");
        int key = new Scanner(System.in).nextInt();
        System.out.println("查找数字的下标为：" + Sort.binarySearch(arr, key));
    }
}
