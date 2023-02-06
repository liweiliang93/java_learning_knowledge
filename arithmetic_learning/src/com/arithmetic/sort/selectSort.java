package com.arithmetic.sort;

import java.util.Arrays;

/**
 * @author liweiliang
 * @create 2023-02-06 15:46
 * @description 直接选择排序
 */
public class selectSort {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 2, 3, 1, 14, 13, 12, 3, 4, 5, 5, 6, 6, 7};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] array) {

        // 开始位置和结束位置
        int begin = 0, end = array.length - 1;

        // begin=end,即排序完毕
        while (begin < end) {

            // 找出最大值和最小值
            int maxi = begin;
            int mini = begin;
            for (int i = begin; i <= end; i++) {
                if (array[i] < array[mini]) {
                    mini = i;
                }
                if (array[i] > array[maxi]) {
                    maxi = i;
                }
            }

            // 最小值放在begin
            int temp = array[mini];
            array[mini] = array[begin];
            array[begin] = temp;

            //若begin位置原来是最大值,则将maxi赋值为mini
            if (begin == maxi) {
                maxi = mini;
            }

            //最大值放在end
            temp = array[maxi];
            array[maxi] = array[end];
            array[end] = temp;
            ++begin;
            --end;
        }
    }
}
