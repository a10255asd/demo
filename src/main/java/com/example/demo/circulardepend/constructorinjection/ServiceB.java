package com.example.demo.circulardepend.constructorinjection;

/**
 * @Author LiuJixue
 * @Date 2022/10/13 16:41
 * @PackageName:com.example.demo.constructorinjection
 * @ClassName: ServiceB
 * @Description: TODO
 * @Version 1.0
 */
public class ServiceB {
    private ServiceA serviceA;
    public ServiceB(ServiceA serviceA){
        this.serviceA = serviceA;
    }
}
