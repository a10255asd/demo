package com.example.demo.question;

/**
 * @Author LiuJixue
 * @Date 2022/10/10 11:12
 * @PackageName:com.example.demo.question
 * @ClassName: StringPool58Demo
 * @Description: TODO
 * @Version 1.0
 */
public class StringPool58Demo {
    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1.intern() == str1);
        System.out.println();
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2.intern() == str2);
    }
}
