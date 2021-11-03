package com.campbell;

import com.campbell.util.SortUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author Campbell
 * @date 2020/6/19
 */
@Slf4j
public class SortUtilsTest extends BaseTest {

    public int[] inputArray() {
        System.out.println("请输入5个数字（以逗号分隔）：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] strings = str.split(",");
        int[] arr = new int[5];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        System.out.println("输入的数组：" + SortUtils.arrayToString(arr));
        return arr;
    }

    @Test
    public void testMinNum() {
        System.out.println("最小数字为：" + SortUtils.minNum(inputArray()));
    }

    @Test
    public void testBubbleSort() {
        int[] arr = inputArray();
        SortUtils.bubbleSort(arr);
        System.out.println("排序后的数组：" + SortUtils.arrayToString(arr));
    }

    @Test
    public void testSelectSort() {
        int[] arr = inputArray();
        SortUtils.selectSort(arr);
        System.out.println("排序后的数组：" + SortUtils.arrayToString(arr));
    }

    @Test
    public void testInsertSort() {
        int[] arr = inputArray();
        SortUtils.insertSort(arr);
        System.out.println("排序后的数组：" + SortUtils.arrayToString(arr));
    }

    @Test
    public void testQuickSort() {
        int[] arr = inputArray();
        SortUtils.quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后的数组：" + SortUtils.arrayToString(arr));
    }

    @Test
    public void testBinarySearch() {
        int[] arr = inputArray();
        System.out.println("请输入查找的数字：");
        int key = new Scanner(System.in).nextInt();
        System.out.println("查找数字的下标为：" + SortUtils.binarySearch(arr, key));
    }
}
