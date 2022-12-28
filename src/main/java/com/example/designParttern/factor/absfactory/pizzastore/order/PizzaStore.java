package com.example.designParttern.factor.absfactory.pizzastore.order;



/**
 * @Author LiuJixue
 * @Date 2022/12/26 16:38
 * @PackageName:com.example.designParttern.factor.absfactory.pizzastore.order
 * @ClassName: PizzaStore
 * @Description: TODO
 * @Version 1.0
 */
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }
}
