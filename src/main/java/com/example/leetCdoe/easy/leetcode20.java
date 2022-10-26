package com.example.leetCdoe.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author LiuJixue
 * @Date 2022/10/25 13:43
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode20
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode20 {
    /**
     * 有效括号
     * */
    public static void main(String[] args) {

    }
    private static final Map<Character,Character> map =
            new HashMap<Character,Character>(){{put('{','}'); put('[',']'); put('(',')'); put('?','?');}};
    public boolean isValid(String s) {
        if(s.length()>0 && !map.containsKey(s.charAt(0))){
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>(){{ add('?'); }};
        for(Character c:s.toCharArray()){
            if(map.containsKey(c)){
                stack.addLast(c);
            }else if(map.get(stack.removeLast())!=c){
                return false;
            }
        }
        return stack.size() == 1;
    }

}
