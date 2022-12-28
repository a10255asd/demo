package com.example.designParttern.factor.simplefactory.pizzastore.order;

import com.example.designParttern.factor.simplefactory.pizzastore.order.OrderPizza;

/**
 * @Author LiuJixue
 * @Date 2022/12/20 19:07
 * @PackageName:com.example.designParttern.factor.simplefactory.pizzastore
 * @ClassName: PizzaStore
 * @Description: 相当于一个客户端，发出订购
 * @Version 1.0
 */
public class PizzaStore {
    public static void main(String[] args) {
        //new OrderPizza();
        // 使用简单工厂模式
        new OrderPizza(new SimpleFactory());
        System.out.println("退出了程序");
    }
}
