package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/10/28 10:44
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode58
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode58 {
    public int lengthOfLastWord(String s) {
        if(s.indexOf(" ") == -1){
            return s.length();
        }
        String[] s1 = s.trim().split(" ");
        String ss = s1[s1.length-1];
        int i =0;
        for (; i < ss.length(); i++) {
            if(ss.charAt(i) != ' '){
                i++;
            }
        }
        return i;
    }
}
