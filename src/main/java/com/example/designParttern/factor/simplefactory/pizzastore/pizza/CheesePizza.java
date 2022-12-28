package com.example.designParttern.factor.simplefactory.pizzastore.pizza;

/**
 * @Author LiuJixue
 * @Date 2022/12/20 18:55
 * @PackageName:com.example.designParttern.factor.simplefactory.pizzastore
 * @ClassName: CheesePizza
 * @Description: TODO
 * @Version 1.0
 */
public class CheesePizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("给制作奶酪披萨准备原材料");
    }
}
