package com.example.designParttern.principle.singleResponsibility;

/**
 * @Author LiuJixue
 * @Date 2022/12/12 15:12
 * @PackageName:com.example.designParttern.singleResponsibility
 * @ClassName: SingleResponsibility2
 * @Description: TODO
 * @Version 1.0
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("摩托车");
        roadVehicle.run("汽车");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");

    }
}
/**
 * 方案2的分析
 * 1、遵守单一职责原则
 * 2、但是这样做的改动很大，即类分解，同事修改客户端
 * 改进：
 * 直接修改Vehicle类，改动的代码比较少
 */
class RoadVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在公里运行");
    }
}

class AirVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在天空运行");
    }
}

class waterVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在水中运行");
    }
}