package com.example.demo.circulardepend.constructorinjection;

/**
 * @Author LiuJixue
 * @Date 2022/10/13 16:43
 * @PackageName:com.example.demo.constructorinjection
 * @ClassName: ClientConstructor
 * @Description: TODO
 * @Version 1.0
 */
public class ClientConstructor {
    public static void main(String[] args) {
        //new ServiceA(new ServiceB(new ServiceA()));
    }
}
