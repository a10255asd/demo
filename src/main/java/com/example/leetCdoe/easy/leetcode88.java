package com.example.leetCdoe.easy;

import java.util.Arrays;

/**
 * @Author LiuJixue
 * @Date 2022/11/8 16:07
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode88
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode88 {
    //    88. 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m + n];
        int a = 0;
        int b = 0;
        int cur ;
        while (a < m || b < n) {
            if (a == m) {
                cur = nums2[b++];
            }else if (b == n) {
                cur = nums1[a++];
            }else if (nums1[a] < nums2[b]) {
                cur = nums1[a++];
            } else {
                cur = nums2[b++];
            }
            sort[a + b - 1] = cur;
        }
        for (int i = 0; i < sort.length; i++) {
            nums1[i] = sort[i];
        }
    }
}
