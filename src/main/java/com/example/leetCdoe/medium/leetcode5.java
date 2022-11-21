package com.example.leetCdoe.medium;

/**
 * @Author LiuJixue
 * @Date 2022/11/21 10:34
 * @PackageName:com.example.leetCdoe.medium
 * @ClassName: leetcode5
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode5 {
    // 5. 最长回文子串
    public static void main(String[] args) {

    }
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        int length = s.length();
        int maxL = 0;
        int maxR = 0;
        int max = 1;
        boolean[][] dp = new boolean[length][length];
        for(int r = 0;r<length;r++){
            for (int l = 0; l < r; l++) {
                if(s.charAt(l) == s.charAt(r) && (r-l <=2 ||dp[l+1][r-1])){
                    dp[l][r] = true;
                    if((r-l+1)>max){
                        max = r-l+1;
                        maxL = l;
                        maxR = r;
                    }
                }
            }
        }
        return s.substring(maxL,maxR+1);

    }
}
