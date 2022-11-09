package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/10/26 14:13
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode26
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode26 {
    /**
     * 删除有序数组中的重复元素 返回长度
     * */
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        //int num = removeDuplicates(nums);

    }
    public int removeDuplicates(int[] nums) {
        if(nums.length <1 ||nums ==null){
            return 0;
        }
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i-1]!=nums[j]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
