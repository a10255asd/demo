package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/11/8 14:34
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode69
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode69 {
    /**
     * 69. x 的平方根
     * */
    public int mySqrt(int x) {
        int l = 0;
        int ans = -1;
        int r = x;
        while (l<=r){
            int mid = l + (r-l)/2;
            if((long)mid * mid <= x){
                ans = mid;
                l = mid+1;
            }else {
                r =  mid-1;
            }
        }
        return ans;
    }
}
