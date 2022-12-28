package com.example.designParttern.factor.simplefactory.pizzastore.pizza;

/**
 * @Author LiuJixue
 * @Date 2022/12/20 18:56
 * @PackageName:com.example.designParttern.factor.simplefactory.pizzastore
 * @ClassName: CreekPizza
 * @Description: TODO
 * @Version 1.0
 */
public class CreekPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("给希腊披萨准备原材料");
    }
}
