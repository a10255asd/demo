package com.example.demo.circulardepend.setinjection;

/**
 * @Author LiuJixue
 * @Date 2022/10/13 16:48
 * @PackageName:com.example.demo.setinjection
 * @ClassName: ServiceAA
 * @Description: TODO
 * @Version 1.0
 */
public class ServiceAA {
    private ServiceBB serviceBB;

    public void setServiceBB(ServiceBB serviceBB){
        this.serviceBB = serviceBB;
        System.out.println("A 里面设置了 B");
    }
}
