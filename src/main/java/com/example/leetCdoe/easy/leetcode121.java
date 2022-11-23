package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/11/23 10:12
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode1221
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode121 {
    //121. 买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] <min){
                min = prices[i];
            }else {
               if(prices[i] - min > max){
                   max = prices[i] - min;
               }
            }
        }
        return max;
    }
}
