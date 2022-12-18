package com.example.designParttern.principle.singleResponsibility;

/**
 * @Author LiuJixue
 * @Date 2022/12/12 15:07
 * @PackageName:com.example.designParttern.singleResponsobility
 * @ClassName: SingleResponsibility
 * @Description: TODO
 * @Version 1.0
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}
// 交通工具类
/**
 * 在方式1的run方法中，违反了单一职责原则
 * 解决方案非常的简单，根据交通工具运行方法不同，分解成不同的类即可
 */
class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在公路上运行。。。");
    }
}
