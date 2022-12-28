package com.example.designParttern.factor.absfactory.pizzastore.order;


import com.example.designParttern.factor.absfactory.pizzastore.pizza.Pizza;

/**
 * @Author LiuJixue
 * @Date 2022/12/26 16:24
 * @PackageName:com.example.designParttern.factor.absfactory.pizzastore.order
 * @ClassName: AbsFactory
 * @Description: 是一个抽象工厂模式的抽象层（接口）
 * @Version 1.0
 */

public interface AbsFactory {
    // 让下面的工厂子类来具体实现
    public Pizza creatPizza(String orderType);
}
