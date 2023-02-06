package com.arithmetic.sort;

import java.util.Arrays;

/**
 * @author liweiliang
 * @create 2022-12-04 15:50
 * @description 快速排序的调用与对比
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 2, 3, 1, 14, 13, 12, 3, 4, 5, 5, 6, 6, 7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /***
     * @author: liweiliang
     * @date: 2022/12/4 16:02
     * @param: [array, start, end]
     * @return: void
     * @details: 快速排序
     **/
    public static void quickSort(int[] array, int start, int end) {
        if (start > end)
            return;
        int i = start;
        int j = end;
        int temp = array[start];
        while (i < j) {
            while (temp <= array[j] && i < j) {
                j--;
            }
            while (temp >= array[i] && i < j) {
                i++;
            }
            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        array[start] = array[i];
        array[i] = temp;
        quickSort(array, start, j - 1);
        quickSort(array, j + 1, end);
    }
}
