package com.example.designParttern.bridge;

/**
 * @Author LiuJixue
 * @Date 2023/1/3 16:59
 * @PackageName:com.example.designParttern.bridge
 * @ClassName: FoldedPhone
 * @Description: 折叠手机类，继承抽象类Phone
 * @Version 1.0
 */
public class FoldedPhone extends Phone{
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    public void open(){
        super.open();
        System.out.println("折叠样式手机");
    }
    public void close(){
        super.close();
        System.out.println("折叠样式手机");
    }
    public void call(){
        super.call();
        System.out.println("折叠样式手机");
    }
}
