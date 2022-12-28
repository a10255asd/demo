package com.example.designParttern.factor.absfactory.pizzastore.order;

import com.example.designParttern.factor.absfactory.pizzastore.pizza.BJCheesePizza;
import com.example.designParttern.factor.absfactory.pizzastore.pizza.BJPepperPizza;
import com.example.designParttern.factor.absfactory.pizzastore.pizza.Pizza;

/**
 * @Author LiuJixue
 * @Date 2022/12/26 16:26
 * @PackageName:com.example.designParttern.factor.absfactory.pizzastore.order
 * @ClassName: BJFactory
 * @Description: 工厂子类
 * @Version 1.0
 */
public class BJFactory implements AbsFactory{
    @Override
    public Pizza creatPizza(String orderType) {
        System.out.println("使用抽象工厂模式");
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if(orderType.equals("peeper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
