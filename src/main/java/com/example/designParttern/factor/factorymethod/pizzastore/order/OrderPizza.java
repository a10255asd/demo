package com.example.designParttern.factor.factorymethod.pizzastore.order;

import com.example.designParttern.factor.factorymethod.pizzastore.pizza.Pizza;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author LiuJixue
 * @Date 2022/12/20 18:59
 * @PackageName:com.example.designParttern.factor.simplefactory.pizzastore.order
 * @ClassName: OrderPizza
 * @Description: TODO
 * @Version 1.0
 */
public abstract class OrderPizza {
    // 定义一个抽象方法，createPizza，让各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);

    // 构造器
    public OrderPizza(){
        Pizza pizza = null;
        String orderType; // 订购披萨的类型
        do{
            orderType = getType();
            pizza = createPizza(orderType); // 抽象方法，由工厂子类完成
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }

    // 写一个方法，可以获取客户希望订购的披萨种类
    private String getType(){
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type");
            String str = strin.readLine();
            return str;
        }catch (IIOException e){
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
