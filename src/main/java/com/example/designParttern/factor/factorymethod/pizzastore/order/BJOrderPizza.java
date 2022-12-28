package com.example.designParttern.factor.factorymethod.pizzastore.order;

import com.example.designParttern.factor.factorymethod.pizzastore.pizza.BJCheesePizza;
import com.example.designParttern.factor.factorymethod.pizzastore.pizza.BJPepperPizza;
import com.example.designParttern.factor.factorymethod.pizzastore.pizza.Pizza;


/**
 * @Author LiuJixue
 * @Date 2022/12/26 14:55
 * @PackageName:com.example.designParttern.factor.factorymethod.pizzastore.order
 * @ClassName: BJOrderPizza
 * @Description: TODO
 * @Version 1.0
 */
public class BJOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
