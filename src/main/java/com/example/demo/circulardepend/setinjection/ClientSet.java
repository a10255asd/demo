package com.example.demo.circulardepend.setinjection;

/**
 * @Author LiuJixue
 * @Date 2022/10/13 16:48
 * @PackageName:com.example.demo.setinjection
 * @ClassName: ClientSet
 * @Description: TODO
 * @Version 1.0
 */
public class ClientSet {
    public static void main(String[] args) {
        ServiceAA a = new ServiceAA();
        ServiceBB b = new ServiceBB();

        b.setServiceAA(a);
        a.setServiceBB(b);
    }
}
