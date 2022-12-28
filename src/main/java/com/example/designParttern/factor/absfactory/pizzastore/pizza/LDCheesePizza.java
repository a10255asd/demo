package com.example.designParttern.factor.absfactory.pizzastore.pizza;

/**
 * @Author LiuJixue
 * @Date 2022/12/26 14:48
 * @PackageName:com.example.designParttern.factor.factorymethod.pizza
 * @ClassName: LDCheesePizza
 * @Description: TODO
 * @Version 1.0
 */
public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦的奶酪pizza");
        System.out.println("伦敦的奶酪pizza 准备原材料");
    }
}
