package com.example.designParttern.dapater.classAdapter;

/**
 * @Author LiuJixue
 * @Date 2023/1/3 14:38
 * @PackageName:com.example.designParttern.dapater
 * @ClassName: Client
 * @Description: TODO
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 类适配器模式
        System.out.println("=====类适配器模式======");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}
