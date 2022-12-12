package com.example.demo.test;

/**
 * @Author LiuJixue
 * @Date 2022/12/6 00:12
 * @PackageName:com.example.demo.test
 * @ClassName: test111
 * @Description: TODO
 * @Version 1.0
 */
public class test111 {


    public static void main(String[] args) {
        byte n = -64;
        int x = 0xff & n;
        System.out.println(x);
        System.out.println((char)n);
        System.out.println(-n);
        System.out.println(Math.abs(n));

        System.out.println(Integer.parseInt(6 + "" + Math.abs(n)));
    }
}
