package com.example.designParttern.factor.simplefactory.pizzastore.order;

import com.example.designParttern.factor.simplefactory.pizzastore.pizza.CreekPizza;
import com.example.designParttern.factor.simplefactory.pizzastore.pizza.Pizza;

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
public class OrderPizza {
    // 构造器
//    public OrderPizza(){
//        Pizza pizza = null;
//        String orderType; // 订购披萨的类型
//        do{
//            orderType = getType();
//            if (orderType.equals("greek")){
//                pizza = new CreekPizza();
//                pizza.setName("希腊披萨");
//            }else if (orderType.equals("cheese")){
//                pizza = new CreekPizza();
//                pizza.setName("奶酪披萨");
//            }else if (orderType.equals("pepper")){
//                pizza = new CreekPizza();
//                pizza.setName("胡椒披萨");
//            } else {
//                break;
//            }
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//        }while (true);
//    }
    // 定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    //构造器
    public OrderPizza(SimpleFactory simpleFactory){
        setFactory(simpleFactory);
    }
    public void setFactory(SimpleFactory simpleFactory){
        String orderType = ""; // 用户输入
        this.simpleFactory = simpleFactory;
        do{
            orderType = getType();
            this.simpleFactory.createPizza(orderType);
            // 输出pizza
            if(pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购pizza失败");
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
