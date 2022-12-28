package com.example.designParttern.factor.factorymethod.pizzastore.pizza;

/**
 * @Author LiuJixue
 * @Date 2022/12/26 14:47
 * @PackageName:com.example.designParttern.factor.factorymethod.pizza
 * @ClassName: LDPepperPizza
 * @Description: TODO
 * @Version 1.0
 */
public class LDPepperPizza extends Pizza{
    @Override
    public void prepare() {
        setName("伦敦的胡椒pizza");
        System.out.println("伦敦的胡椒pizza 准备原材料");
    }
}
