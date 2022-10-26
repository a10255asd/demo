package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/10/25 09:44
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode14
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode14 {
    public static void main(String[] args) {
        System.out.println();
        String[] strs = new String[]{"ab","a"};
        String ans = longestCommonPrefix(strs);
        System.out.println(ans);
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length <1){
            return "";
        }
        String ans = strs[0];
        for (int s = 1; s < strs.length; s++) {
            int i = 0;
            for (; i < ans.length()&&i<strs[s].length(); i++) {
                if (ans.charAt(i)!=strs[s].charAt(i)){
                    break;
                }
            }
            ans = ans.substring(0,i);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
}
