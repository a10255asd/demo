package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/11/10 10:16
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode104
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode104 {
    // 二叉树最大深度
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.right),maxDepth(root.left)) + 1;
    }
}
