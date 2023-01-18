package com.atguigu.java.java1;

/**
 * @author liweiliang
 * @create 2022-11-25 11:42
 * @description 直接插入排序
 */
public class SortedTest {
    public static void main(String[] args) {
        int[] number = {1,2,4,3,6,5,14,13,12};
        int[] ints = insertionSort(number);
        for(int i : ints){
            System.out.print(i + " ");
        }
    }

    public static int[] insertionSort(int[] array) {
        if (array.length == 0) return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}

