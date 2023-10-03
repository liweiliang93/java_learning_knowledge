package com.arithmetic.lanqiao;

import java.util.Arrays;

/**
 * @author liweiliang
 * @create 2022-12-08 12:01
 * @description
 */
public class SortAndSorted {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,-1,6,-4,8};
        int[] brr = Arrays.copyOfRange(arr,0,5);
        Arrays.sort(brr);
        System.out.println(Arrays.toString(brr));
    }
}
