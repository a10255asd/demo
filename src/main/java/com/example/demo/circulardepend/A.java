package com.example.demo.circulardepend;

/**
 * @Author LiuJixue
 * @Date 2022/10/13 23:10
 * @PackageName:com.example.demo.circulardepend
 * @ClassName: A
 * @Description: TODO
 * @Version 1.0
 */
public class A {
    private B b;

    public B getB(){
        return b;
    }
    public void setB(B b){
        this.b = b;
    }
    public A(){
        System.out.println("---A created success");
    }
}
