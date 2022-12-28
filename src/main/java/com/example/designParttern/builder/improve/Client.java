package com.example.designParttern.builder.improve;

/**
 * @Author LiuJixue
 * @Date 2022/12/28 23:59
 * @PackageName:com.example.designParttern.builder.improve
 * @ClassName: Client
 * @Description: TODO
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        // 准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        // 完成盖房子，返回产品（房子）
        House house = houseDirector.constructHouse();
        System.out.println("---------------------------");
        // 盖高楼
        HighBuilding highBuilding = new HighBuilding();
        //重制建造者
        houseDirector.setHouseBuilder(highBuilding);
        // 完成盖房子，返回产品（高楼）
        House house1 = houseDirector.constructHouse();
    }
}
