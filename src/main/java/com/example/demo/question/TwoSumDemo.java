package com.example.demo.question;

/**
 * @Author LiuJixue
 * @Date 2022/10/10 17:09
 * @PackageName:com.example.demo.question
 * @ClassName: TwoSumDemo
 * @Description: TODO
 * @Version 1.0
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 * */
public class TwoSumDemo {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] index = twoSum1(nums,target);
    }
    // 暴力破解
    public static  int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(target-nums[i] == nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    // 通过hash完成
    public static  int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map  = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           int num =  target -nums[i];
           if(map.containsKey(num)){
                return new int[]{map.get(num),i};
           }
           map.put(nums[i],i);
        }
        return null;
    }
}
