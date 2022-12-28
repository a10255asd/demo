package com.example.designParttern.prototype.improve;

/**
 * @Author LiuJixue
 * @Date 2022/12/28 15:42
 * @PackageName:com.example.designParttern.prototype.improve
 * @ClassName: Client
 * @Description: TODO
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("原型模式完成对象创建");
        Sheep sheep = new Sheep("tom",1,"白色");
        sheep.friend = new Sheep("jack",2,"黑色");

        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();
        Sheep sheep5 = (Sheep) sheep.clone();

        System.out.println(sheep + "sheep.friend= + " + sheep.friend.hashCode());
        System.out.println(sheep1+ "sheep1.friend= + " + sheep1.friend.hashCode());
        System.out.println(sheep2+ "sheep2.friend= + " + sheep2.friend.hashCode());
        System.out.println(sheep3+ "sheep3.friend= + " + sheep3.friend.hashCode());
        System.out.println(sheep4+ "sheep4.friend= + " + sheep4.friend.hashCode());
        System.out.println(sheep5+ "sheep5.friend= + " + sheep5.friend.hashCode());
    }
}
