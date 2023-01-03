package com.example.designParttern.bridge;


/**
 * @Author LiuJixue
 * @Date 2023/1/3 16:55
 * @PackageName:com.example.designParttern.bridge
 * @ClassName: VIvo
 * @Description: TODO
 * @Version 1.0
 */
public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println("Vivo手机开机");
    }

    @Override
    public void close() {
        System.out.println("Vivo手机关机");
    }

    @Override
    public void call() {
        System.out.println("Vivo手机打电话");
    }
}
