package com.example.leetCdoe.easy;


import sun.misc.Queue;

import java.util.Stack;

/**
 * @Author LiuJixue
 * @Date 2022/10/24 09:38
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leecode9
 * @Description: TODO
 * @Version 1.0
 */
public class leecode9 {
    public static void main(String[] args) {
        /**
         *  回文数 123
         * */
        System.out.println(0*10+123%10);
        System.out.println(123/10);
        System.out.println(3*10+12%10);
        System.out.println(12/10);
        System.out.println(32*10+1%10);
        System.out.println(1/10);
    }
    public boolean isPalindrome(int x) {
        if(x <0){
            return false;
        }
        int cur = 0;
        int num = x;
        while (num!= 0){
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }
}
