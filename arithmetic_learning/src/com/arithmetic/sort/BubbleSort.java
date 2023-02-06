package com.arithmetic.sort;

import java.util.Arrays;

/**
 * @author liweiliang
 * @create 2023-02-06 16:40
 * @description 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 2, 3, 1, 14, 13, 12, 3, 4, 5, 5, 6, 6, 7};
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] array, int n) {
        int end = n;
        int isFlag = 0;
        while (end >= 0) {
            for (int i = 1; i < end; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isFlag = 1;
                }
                if (isFlag == 0){
                    break;
                }
            }
            --end;
        }
    }
}
