package com.example.designParttern.bridge;

import com.example.demo.circulardepend.B;

/**
 * @Author LiuJixue
 * @Date 2023/1/3 16:54
 * @PackageName:com.example.designParttern.bridge
 * @ClassName: Xiaomi
 * @Description: TODO
 * @Version 1.0
 */
public class Xiaomi implements Brand {
    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void close() {
        System.out.println("小米手机关机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }
}
