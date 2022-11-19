package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/11/16 10:27
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode111
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode111 {
    //111. 二叉树的最小深度
    public static void main(String[] args) {

    }
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int m1 = minDepth(root.right);
        int m2 = minDepth(root.left);

        return root.left == null || root.right == null ? m1+m2+1 : Math.min(m1,m2)+1;
    }
}
