package com.example.designParttern.builder.improve;

/**
 * @Author LiuJixue
 * @Date 2022/12/28 23:52
 * @PackageName:com.example.designParttern.builder.improve
 * @ClassName: HighBuilding
 * @Description: TODO
 * @Version 1.0
 */
public class HighBuilding extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("高楼地基100米");
    }

    @Override
    public void buildWall() {
        System.out.println("高楼的砌墙20厘米");
    }

    @Override
    public void roofed() {
        System.out.println("高楼的透明屋顶");
    }
}
