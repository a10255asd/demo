package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/11/16 10:03
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode110
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode110 {
    // 110. 平衡二叉树
    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }else {
            return Math.abs((maxDepth(root.left) - maxDepth(root.right))) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.right),maxDepth(root.left)) + 1;
    }
}
