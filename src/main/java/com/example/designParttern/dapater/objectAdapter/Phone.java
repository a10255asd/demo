package com.example.designParttern.dapater.objectAdapter;

/**
 * @Author LiuJixue
 * @Date 2023/1/3 14:36
 * @PackageName:com.example.designParttern.dapater
 * @ClassName: Phone
 * @Description: TODO
 * @Version 1.0
 */
public class Phone {
    // 充电方法
    public void charging(IVoltage5V iVoltage5V){
        if (iVoltage5V.output5V() == 5){
            System.out.println("电压5V 可以充电");
        }else if(iVoltage5V.output5V() > 5){
            System.out.println("电压大于5V，不能充电");
        }
    }
}
