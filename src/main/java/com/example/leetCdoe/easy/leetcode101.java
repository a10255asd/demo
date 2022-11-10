package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/11/10 09:44
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode101
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode101 {
    // 101、对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }else {
           return isSame(root.left,root.right);
        }
    }

    public boolean isSame(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }else if(left.val != right.val){
            return false;
        }else {
            return isSame(left.left,right.right) &&isSame(left.right,right.left);
        }
    }
}
