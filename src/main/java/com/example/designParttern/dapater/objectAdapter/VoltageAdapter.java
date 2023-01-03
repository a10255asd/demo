package com.example.designParttern.dapater.objectAdapter;

/**
 * @Author LiuJixue
 * @Date 2023/1/3 14:31
 * @PackageName:com.example.designParttern.dapater
 * @ClassName: VoltageAdapter
 * @Description: 适配器类
 * @Version 1.0
 */
public class VoltageAdapter implements IVoltage5V {
    private Voltage220V voltage220V; //关联关系中的聚合关系

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        // 获取220V电压
        int dstV = 0;
        if (null != voltage220V){
            int src = voltage220V.output220V(); // 获取220V电压
            System.out.println("使用对象适配器，进行转换");
            dstV = src / 44;
            System.out.println("适配完成，输出电压为：" + dstV);
        }
        return dstV;
    }
}
