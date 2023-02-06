package com.arithmetic.sort;

/**
 * @author liweiliang
 * @create 2022-11-28 10:13
 * @description 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 7, 5, 4, 14, 13, 11};
        int[] ints = binaryInsertionSort(arr);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    /***
     * @details: 直接插入排序
     * @param: [array]
     * @return: int[]
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return null;
        int current;

        // 循环次数为n-1,循环从0开始
        for (int i = 0; i < array.length - 1; i++) {

            // 保存当前要排序的数current
            current = array[i + 1];

            // 控制要比较的数的下标为current之前的
            int preIndex = i;

            // 将插入位置腾出来
            while (preIndex >= 0 && current < array[preIndex]) {// 将
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }

            // 插入
            array[preIndex + 1] = current;
        }
        return array;
    }

    /***
     * @details: 二分法插入排序
     * @param: [array]
     * @return: int[]
     */
    public static int[] binaryInsertionSort(int[] array) {

        // 外层循环遍历数组元素
        for (int i = 0; i < array.length; i++) {

            // 内层通过二分查找,锁定到arr[i]目标位置left
            int temp = array[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // 将left及其右边元素右移1位
            for (int j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
            }

            // 将 arr[i]放在目标位置（如果自身本来就在这个位置则不必移动）
            if (left != i) {
                array[left] = temp;
            }
        }
        return array;
    }
}
