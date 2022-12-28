package com.example.designParttern.builder;

/**
 * @Author LiuJixue
 * @Date 2022/12/28 22:47
 * @PackageName:com.example.designParttern.builder
 * @ClassName: CommonHouse
 * @Description: TODO
 * @Version 1.0
 */
public class CommonHouse extends AbstractHouse{
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子封顶");
    }
}
