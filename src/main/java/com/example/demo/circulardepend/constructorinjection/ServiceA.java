package com.example.demo.circulardepend.constructorinjection;

/**
 * @Author LiuJixue
 * @Date 2022/10/13 16:41
 * @PackageName:com.example.demo.constructorinjection
 * @ClassName: ServiceA
 * @Description: TODO
 * @Version 1.0
 */
public class ServiceA {
    private ServiceB serviceB;
    public ServiceA(ServiceB serviceB){
       this.serviceB = serviceB;
    }
}
