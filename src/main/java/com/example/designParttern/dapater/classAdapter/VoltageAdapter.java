package com.example.designParttern.dapater.classAdapter;

/**
 * @Author LiuJixue
 * @Date 2023/1/3 14:31
 * @PackageName:com.example.designParttern.dapater
 * @ClassName: VoltageAdapter
 * @Description: 适配器类
 * @Version 1.0
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V{
    @Override
    public int output5V() {
        // 获取220V电压
        int srcV = output220V();
        int dstV = srcV / 44; // 专成 5V
        return dstV;
    }
}
