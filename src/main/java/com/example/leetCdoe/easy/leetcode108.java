package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/11/10 10:34
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode108
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode108 {
    //108、将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
       return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);
        return root;
    }
}
