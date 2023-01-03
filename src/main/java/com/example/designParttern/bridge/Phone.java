package com.example.designParttern.bridge;

/**
 * @Author LiuJixue
 * @Date 2023/1/3 16:57
 * @PackageName:com.example.designParttern.bridge
 * @ClassName: Phone
 * @Description: TODO
 * @Version 1.0
 */
public abstract class Phone {
    // 组合品牌
    private Brand brand;
    // 构造器
    public Phone(Brand brand) {
        this.brand = brand;
    }
    protected void open(){
        this.brand.open();
    }
    protected void close(){
        this.brand.close();
    }
    protected void call(){
        this.brand.call();
    }
}

