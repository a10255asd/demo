package com.example.designParttern.factor.absfactory.pizzastore.order;

import com.example.designParttern.factor.absfactory.pizzastore.pizza.Pizza;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author LiuJixue
 * @Date 2022/12/26 16:32
 * @PackageName:com.example.designParttern.factor.absfactory.pizzastore.order
 * @ClassName: OrderPizza
 * @Description: TODO
 * @Version 1.0
 */
public class OrderPizza {
    AbsFactory factory;

    public OrderPizza(AbsFactory factory){
        setFactory(factory);
    }
    private void setFactory(AbsFactory factory){
        Pizza pizza = null;
        String orderType = ""; // 用户输入
        this.factory = factory;
        do{
            orderType = getType();
            // factory 可能是北京的工厂子类，也可能是伦敦的工厂子类
            pizza = factory.creatPizza(orderType);
            if(pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("订购失败");
                break;
            }
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
