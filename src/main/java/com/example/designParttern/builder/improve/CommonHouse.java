package com.example.designParttern.builder.improve;

/**
 * @Author LiuJixue
 * @Date 2022/12/28 23:46
 * @PackageName:com.example.designParttern.builder.improve
 * @ClassName: CommonHouse
 * @Description: TODO
 * @Version 1.0
 */
public class CommonHouse extends HouseBuilder{

    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基5米");
    }

    @Override
    public void buildWall() {
        System.out.println("普通房子砌墙10厘米");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子屋顶");
    }
}
