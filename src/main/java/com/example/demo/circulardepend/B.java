package com.example.demo.circulardepend;

/**
 * @Author LiuJixue
 * @Date 2022/10/13 23:10
 * @PackageName:com.example.demo.circulardepend
 * @ClassName: B
 * @Description: TODO
 * @Version 1.0
 */
public class B {
    private A a;

    public A getA(){
        return a;
    }
    public void setA(A a){
        this.a = a;
    }
    public B(){
        System.out.println("---B created success");
    }
}
