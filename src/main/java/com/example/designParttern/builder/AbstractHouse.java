package com.example.designParttern.builder;

/**
 * @Author LiuJixue
 * @Date 2022/12/28 22:35
 * @PackageName:com.example.designParttern.builder
 * @ClassName: AbstractHouse
 * @Description: TODO
 * @Version 1.0
 */
public abstract class AbstractHouse {
    // 打地基
    public abstract void buildBasic();
    // 砌墙
    public abstract void buildWalls();
    // 封顶
    public abstract void roofed();

    public void build(){
        buildBasic();
        buildWalls();
        roofed();
    }
}
