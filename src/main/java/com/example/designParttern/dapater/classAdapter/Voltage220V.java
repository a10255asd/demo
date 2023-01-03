package com.example.designParttern.dapater.classAdapter;

/**
 * @Author LiuJixue
 * @Date 2023/1/3 14:28
 * @PackageName:com.example.designParttern.dapater
 * @ClassName: Voltage220V
 * @Description: 被适配的类
 * @Version 1.0
 */
public class Voltage220V {
    // 输出220v电压
    public int output220V(){
        int src = 220;
        System.out.println("电压=" + src + "伏");
        return src;
    }
}
