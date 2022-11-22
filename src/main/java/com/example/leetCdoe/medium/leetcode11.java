package com.example.leetCdoe.medium;

/**
 * @Author LiuJixue
 * @Date 2022/11/22 10:43
 * @PackageName:com.example.leetCdoe.medium
 * @ClassName: leetcode11
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode11 {
    //11. 盛最多水的容器
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length-1;
        while(start<end){
            max = height[start]<height[end]?
                    Math.max(max,(end-start)*height[start++])
                    :Math.max(max,(end-start)*height[end--]);
        }
        return max;
    }
}
