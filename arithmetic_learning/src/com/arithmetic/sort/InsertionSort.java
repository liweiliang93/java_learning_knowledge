package com.arithmetic.sort;

/**
 * @author liweiliang
 * @create 2022-11-28 10:13
 * @description 直接插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 7, 5, 4, 14, 13, 11};
        int[] ints = insertionSort(arr);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    public static int[] insertionSort(int[] array) {
        if (array.length == 0) return null;
        int current;
        for (int i = 0; i < array.length - 1; i++) { //循环次数为n-1,循环从0开始
            current = array[i + 1];//保存当前要排序的数current
            int preIndex = i;//控制要比较的数的下标为current之前的
            while (preIndex >= 0 && current < array[preIndex]) {//将
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
