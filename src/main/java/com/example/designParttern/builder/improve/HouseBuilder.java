package com.example.designParttern.builder.improve;

/**
 * @Author LiuJixue
 * @Date 2022/12/28 23:41
 * @PackageName:com.example.designParttern.builder.improve
 * @ClassName: HouseBuilder
 * @Description: 抽象的建造者
 * @Version 1.0
 */
public abstract class HouseBuilder {
    protected House house = new House();

    // 将建造的流程写好，抽象的方法
    public abstract void buildBasic();
    public abstract void buildWall();
    public abstract void roofed();

    // 建房,将产品（房子）返回
    public House buildHouse(){
        return house;
    }
}
