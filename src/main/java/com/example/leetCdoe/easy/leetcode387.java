package com.example.leetCdoe.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiuJixue
 * @Date 2022/11/21 16:41
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode387
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode387 {
    //387. 字符串中的第一个唯一字符
    public int firstUniqChar(String s) {
        // 创建一个map用来存储字符串和出现的次数
        Map<Character,Integer> map = new HashMap<>();
        // 第一次循环，根据字符和出现次数存入map
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(map.containsKey(ch)){
                Integer value = map.get(ch);
                value+= 1;
                map.put(ch,value);
            }else {
                map.put(ch,1);
            }
        }
        // 第二次循环，找到map中value为1的key的字符串，返回他的坐标i
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
