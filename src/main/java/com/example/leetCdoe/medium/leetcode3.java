package com.example.leetCdoe.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author LiuJixue
 * @Date 2022/11/22 09:31
 * @PackageName:com.example.leetCdoe.medium
 * @ClassName: leetcode3
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode3 {
    //3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n  = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for (int start = 0,end = 0; end < n; end++) {
            Character temp = s.charAt(end);
            if(map.containsKey(temp)){
                start = Math.max(map.get(temp),start);
            }
            ans = Math.max(ans,end-start+1);
            map.put(s.charAt(end),end+1);
        }
        return ans;
    }
}
