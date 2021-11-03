package com.campbell.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author Campbell
 * @date 2020/6/19
 */
@Slf4j
public class SortUtils {

    /**
     * 按指定格式输出数组
     *
     * @param arr
     * @return
     */
    public static String arrayToString(int[] arr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                stringBuffer.append(arr[i]).append(",");
            } else {
                stringBuffer.append(arr[i]);
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /**
     * 数组最小值
     *
     * @param arr
     * @return
     */
    public static int minNum(int[] arr) {
        //最小数的下标初始值为第一个数的下标
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return arr[minIndex];
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        //数字两两相比，一共进行n-1轮，第一轮所有的数字都参与，往后每一轮都要去掉最后一个数（最大的数）
        for (int i = 0; i < arr.length - 1; i++) {
            //设定一个标记，若为true，则表示此轮循环没有进行交换，也就是待排序列已经有序，排序已经完成
            boolean flag = true;
            //每轮比较的次数，前面的数和后面的数进行比较，减去1是为了避免数组下标越界，i可以看作是不需要比较的数字个数
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int max = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = max;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        //选出最小的数字，一共进行n-1轮，第一轮所有的数字都参与，往后每一轮都要去掉第一个数（最小的数）
        for (int i = 0; i < arr.length - 1; i++) {
            //将每轮第一个数的下标作为最小数下标初始值
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    //记录目前能找到的最小数的下标
                    minIndex = j;
                }
            }
            //将找到的最小值与本轮第一个数进行交换
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        //将第一个数字看做一个有序序列，从第二个数字开始向前扫描
        for (int i = 1; i < arr.length; i++) {
            //将每轮第一个数取出来
            int temp = arr[i];
            int j;
            //将取出来的数字从后往前进行比较，如果前面数字比它大，就将前面的数字后移一位，否则循环终止
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }
            //插入数字
            arr[j + 1] = temp;
        }
    }


    /**
     * 快速排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        //递归结束条件
        if (left > right) {
            return;
        }
        int rawLeft = left;
        int rawRight = right;
        int baseNumber = arr[rawLeft];
        while (left != right) {
            while (arr[right] >= baseNumber && right > left) {
                right--;
            }
            while (arr[left] <= baseNumber && right > left) {
                left++;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        int temp = arr[left];
        arr[left] = baseNumber;
        arr[rawLeft] = temp;
        quickSort(arr, rawLeft, left - 1);
        quickSort(arr, left + 1, rawRight);
    }

    /**
     * 二分查找
     *
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearch(int[] arr, int key) {
        //先排序
        Arrays.sort(arr);
        log.info("排序后的数组：" + SortUtils.arrayToString(arr));
        //每次查找的下标起点
        int startIndex = 0;
        //每次查找的下标终点
        int endIndex = arr.length - 1;
        while (startIndex <= endIndex) {
            //每次查找的下标中间值
            int midIndex = (startIndex + endIndex) >> 1;
            if (key < arr[midIndex]) {
                endIndex = midIndex - 1;
            } else if (key > arr[midIndex]) {
                startIndex = midIndex + 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }

}
