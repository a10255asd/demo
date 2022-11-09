package com.example.leetCdoe.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiuJixue
 * @Date 2022/11/9 10:31
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode94
 * @Description: TODO
 * @Version 1.0
 */

class TreeNode {
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

public class leetcode94 {
    // 二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res,root);
        return res;
    }
    public void dfs(List<Integer> res,TreeNode root){
        if(root == null){
            return;
        }
        dfs(res,root.left);
        res.add(root.val);
        dfs(res,root.right);
    }

}
