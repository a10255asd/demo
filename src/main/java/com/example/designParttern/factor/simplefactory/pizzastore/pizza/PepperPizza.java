package com.example.designParttern.factor.simplefactory.pizzastore.pizza;

/**
 * @Author LiuJixue
 * @Date 2022/12/21 16:00
 * @PackageName:com.example.designParttern.factor.simplefactory.pizzastore.pizza
 * @ClassName: PepperPizza
 * @Description: TODO
 * @Version 1.0
 */
public class PepperPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("给胡椒披萨准备原材料");
    }
}
