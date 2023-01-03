package com.example.designParttern.bridge;

/**
 * @Author LiuJixue
 * @Date 2023/1/3 17:04
 * @PackageName:com.example.designParttern.bridge
 * @ClassName: Client
 * @Description: TODO
 * @Version 1.0
 */
public class Client {
    // 获取折叠式手机（样式 + 品牌）
    public static void main(String[] args) {
        Phone phone1 = new FoldedPhone(new Xiaomi());
        phone1.open();
        phone1.call();
        phone1.close();
        Phone phone2 = new FoldedPhone(new Vivo());
        phone2.open();
        phone2.call();
        phone2.close();
        System.out.println("==========================");
        Phone phone3 = new UpRightPhone(new Xiaomi());
        phone3.open();
        phone3.call();
        phone3.close();
        Phone phone4 = new UpRightPhone(new Vivo());
        phone4.open();
        phone4.call();
        phone4.close();
    }
}
