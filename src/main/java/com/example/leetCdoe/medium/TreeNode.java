package com.example.leetCdoe.medium;

/**
 * @Author LiuJixue
 * @Date 2022/11/21 16:38
 * @PackageName:com.example.leetCdoe.medium
 * @ClassName: TreeNode
 * @Description: TODO
 * @Version 1.0
 */


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
