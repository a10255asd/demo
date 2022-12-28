package com.example.designParttern.builder.improve;

/**
 * @Author LiuJixue
 * @Date 2022/12/28 23:54
 * @PackageName:com.example.designParttern.builder.improve
 * @ClassName: HouseDirector
 * @Description: 指挥者，这里动态的指定制作流程
 * @Version 1.0
 */
public class HouseDirector {
    HouseBuilder houseBuilder = null;

    // 构造器传入houseBuilder
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
    // setter 方法传入 houseBuilder
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // 如何处理建造房子的流程，交给指挥者
    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWall();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
