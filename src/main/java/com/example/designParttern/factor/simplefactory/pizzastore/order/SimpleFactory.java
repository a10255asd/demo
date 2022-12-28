package com.example.designParttern.factor.simplefactory.pizzastore.order;

import com.example.designParttern.factor.simplefactory.pizzastore.pizza.CreekPizza;
import com.example.designParttern.factor.simplefactory.pizzastore.pizza.Pizza;

/**
 * @Author LiuJixue
 * @Date 2022/12/21 16:20
 * @PackageName:com.example.designParttern.factor.simplefactory.pizzastore.order
 * @ClassName: SimpleFactory
 * @Description: 简单工厂类
 * @Version 1.0
 */
public class SimpleFactory {
    // 根据orderType返回对应的Pizza对象
    public Pizza createPizza(String orderType){
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")){
            pizza = new CreekPizza();
            pizza.setName("希腊披萨");
        }else if (orderType.equals("cheese")){
            pizza = new CreekPizza();
            pizza.setName("奶酪披萨");
        }else if (orderType.equals("pepper")){
            pizza = new CreekPizza();
            pizza.setName("胡椒披萨");
        }
        return pizza;
    }
}
