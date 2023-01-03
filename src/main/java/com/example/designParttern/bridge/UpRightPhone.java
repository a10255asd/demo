package com.example.designParttern.bridge;

/**
 * @Author LiuJixue
 * @Date 2023/1/3 17:08
 * @PackageName:com.example.designParttern.bridge
 * @ClassName: UpRightPhone
 * @Description: TODO
 * @Version 1.0
 */
public class UpRightPhone extends Phone{
    public UpRightPhone(Brand brand) {
        super(brand);
    }
    public void open(){
        super.open();
        System.out.println("直立样式手机");
    }
    public void close(){
        super.close();
        System.out.println("直立样式手机");
    }
    public void call(){
        super.call();
        System.out.println("直立样式手机");
    }
}
