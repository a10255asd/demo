package com.example.leetCdoe.easy;

/**
 * @Author LiuJixue
 * @Date 2022/11/3 09:51
 * @PackageName:com.example.leetCdoe.easy
 * @ClassName: leetcode66
 * @Description: TODO
 * @Version 1.0
 */
public class leetcode66 {
    /**
     * 加一s
     * */
    public static void main(String[] args) {

    }
    public int[] plusOne(int[] digits) {
        for (int i = digits.length; i >= 0; i--) {
            if(digits[i] == 9){
                digits[i] =0;
            }else {
                digits[i] += 1;
                return digits;
            }
        }
        digits =new int[digits.length +1];
        digits[0] = 1;
        return digits;
    }
}
