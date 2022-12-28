package com.example.designParttern.factor.factorymethod.pizzastore.pizza;

/**
 * @Author LiuJixue
 * @Date 2022/12/26 14:45
 * @PackageName:com.example.designParttern.factor.factorymethod.pizza
 * @ClassName: BJCheesePizza
 * @Description: TODO
 * @Version 1.0
 */
public class BJCheesePizza extends Pizza{
    @Override
    public void prepare() {
        setName("北京的奶酪pizza");
        System.out.println("北京的奶酪pizza 准备原材料");
    }
}
