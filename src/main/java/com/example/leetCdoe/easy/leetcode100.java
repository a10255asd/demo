package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/11/9 14:19
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode100
 * @Description: TODO
 * @Version 1.0
 */

public class leetcode100 {
    // 100.相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p ==null || q == null){
            return false;
        }else if(p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}
