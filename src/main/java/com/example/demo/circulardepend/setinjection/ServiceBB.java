package com.example.demo.circulardepend.setinjection;

/**
 * @Author LiuJixue
 * @Date 2022/10/13 16:48
 * @PackageName:com.example.demo.setinjection
 * @ClassName: ServiceBB
 * @Description: TODO
 * @Version 1.0
 */
public class ServiceBB {
    private ServiceAA serviceAA;

    public void setServiceAA(ServiceAA serviceAA){
        this.serviceAA = serviceAA;
        System.out.println("B 里面设置了 A");
    }
}
