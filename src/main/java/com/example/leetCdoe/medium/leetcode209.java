package com.example.leetCdoe.medium;

/**
 * @Author LiuJixue
 * @Date 2022/11/23 10:40
 * @PackageName:com.example.leetCdoe.medium
 * @ClassName: leetcode209
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode209 {
    //209. 长度最小的子数组
    public int minSubArrayLen(int target, int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while( end <nums.length){
            sum = sum +nums[end];
            while(sum >= target){
                ans = Math.min(ans,end-start+1);
                sum = sum - nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE?0:ans;
    }
}
