package com.example.designParttern.factor.factorymethod.pizzastore.order;

import com.example.designParttern.factor.factorymethod.pizzastore.pizza.*;

/**
 * @Author LiuJixue
 * @Date 2022/12/26 14:59
 * @PackageName:com.example.designParttern.factor.factorymethod.pizzastore.order
 * @ClassName: LDOrderPizza
 * @Description: TODO
 * @Version 1.0
 */
public class LDOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
